package com.bikeshare.ncs.service.impl;

import com.bikeshare.ncs.bean.BaseUser;
import com.bikeshare.ncs.bean.BaseUserExample;
import com.bikeshare.ncs.bean.BaseUserRole;
import com.bikeshare.ncs.bean.BaseUserRoleExample;
import com.bikeshare.ncs.bean.extend.BaseUserExtend;
import com.bikeshare.ncs.dao.BaseUserMapper;
import com.bikeshare.ncs.dao.BaseUserRoleMapper;
import com.bikeshare.ncs.dao.extend.BaseUserExtendMapper;
import com.bikeshare.ncs.service.IBaseUserService;
import com.bikeshare.ncs.utils.CustomerException;
import com.bikeshare.ncs.vm.UserVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BaseUserService implements IBaseUserService {
    @Resource
    private BaseUserExtendMapper baseUserExtendMapper;
    @Resource
    private BaseUserMapper baseUserMapper;
    @Resource
    private BaseUserRoleMapper baseUserRoleMapper;

    @Override
    public BaseUser login(UserVM userVM) throws CustomerException {
        BaseUserExample example = new BaseUserExample();
        example.createCriteria().andUsernameEqualTo(userVM.getUsername());
        List<BaseUser> list = baseUserMapper.selectByExample(example);
        if(list.size()<=0){
            throw new CustomerException("该用户不存在");
        }
        BaseUser user = list.get(0);
        if(!user.getPassword().equals(userVM.getPassword())){
            throw new CustomerException("密码不匹配");
        }
        return user;

    }

    @Override
    public BaseUserExtend findById(long id) {
        return baseUserExtendMapper.selectById(id);
    }

    @Override
    public List<BaseUser> findAll() {
        return baseUserMapper.selectByExample(new BaseUserExample());
    }

    @Override
    public List<BaseUserExtend> cascadeRoleFindAll() {
        return baseUserExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(BaseUser baseUser) throws CustomerException {
        if(baseUser.getId()!=null){
            baseUserMapper.updateByPrimaryKey(baseUser);
        } else {
            // 判断用户名是否被占用
            BaseUserExample example = new BaseUserExample();
            example.createCriteria().andUsernameEqualTo(baseUser.getUsername());
            List<BaseUser> list = baseUserMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该用户已经被占用");
            }
            // 初始化
            baseUser.setRegisterTime(new Date().getTime());
            baseUser.setStatus(BaseUserExtend.STATUS_NORMAL);
            baseUserMapper.insert(baseUser);
        }
    }

    @Override
    public void changeStatus(long id,String status) throws CustomerException {
        BaseUser user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        user.setStatus(status);
        baseUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        BaseUser user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        baseUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void setRoles(long id, List<Long> roles) {
        // 根据userid查询自己的角色
        BaseUserRoleExample example = new BaseUserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        // 用户角色关系,获取所有老的角色
        List<BaseUserRole> list = baseUserRoleMapper.selectByExample(example);
        List<Long> oldRoles = new ArrayList<>();
        Iterator<BaseUserRole> iterator = list.iterator();
        while(iterator.hasNext()){
            oldRoles.add(iterator.next().getRoleId());
        }
        // [1,2,3] -> [3,4] 添加1,2 => [1,2,3,4]
        // 依次判断新角色是否存在于list中，如果不存在则添加
        for(Long roleId : roles){
            if(!oldRoles.contains(roleId)){
                BaseUserRole userRole = new BaseUserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(id);
                baseUserRoleMapper.insert(userRole);
            }
        }
        // [1,2,3] -> [1,2,3,4]   删除 3,4  => [1,2]
        // 依次判断老的角色是否存在于roles中，如果不存在则删除
        for(BaseUserRole userRole : list){
            if(!roles.contains(userRole.getRoleId())){
                BaseUserRoleExample example1 = new BaseUserRoleExample();
                baseUserRoleMapper.deleteByPrimaryKey(userRole.getId());
            }
        }


    }
}
