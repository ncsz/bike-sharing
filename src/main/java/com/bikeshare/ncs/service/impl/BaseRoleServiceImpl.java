package com.bikeshare.ncs.service.impl;
import com.bikeshare.ncs.bean.BaseRole;
import com.bikeshare.ncs.bean.BaseRoleExample;
import com.bikeshare.ncs.bean.BaseRolePrivilege;
import com.bikeshare.ncs.bean.BaseRolePrivilegeExample;
import com.bikeshare.ncs.bean.extend.BaseRoleExtend;
import com.bikeshare.ncs.dao.BaseRoleMapper;
import com.bikeshare.ncs.dao.BaseRolePrivilegeMapper;
import com.bikeshare.ncs.dao.extend.BaseRoleExtendMapper;
import com.bikeshare.ncs.service.IBaseRoleService;
import com.bikeshare.ncs.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

 /**
  * @name BaseRoleServiceImpl
  * @date 2020/4/30
  * @author ncs
  * @description 角色实现类
 **/
@Service
public class BaseRoleServiceImpl implements IBaseRoleService {
    @Resource
    private BaseRoleMapper baseRoleMapper;
    @Resource
    private BaseRoleExtendMapper baseRoleExtendMapper;
    @Resource
    private BaseRolePrivilegeMapper baseRolePrivilegeMapper;

    @Override
    public void authorization(long roleId, List<Long> privilegeIds) {
        // 根据roleid查询出所有的权限
        BaseRolePrivilegeExample example = new BaseRolePrivilegeExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<BaseRolePrivilege> list = baseRolePrivilegeMapper.selectByExample(example);
        // 将list转换为privilegeIDs的集合
        List<Long> old_privilegeIds = new ArrayList<>();
        for(BaseRolePrivilege rp : list){
            old_privilegeIds.add(rp.getPrivilegeId());
        }
        // 依次判断privilegeIds 是否存在old_privilegeIds，如果不在则插入
        for(long privilegeId : privilegeIds){
            if (!old_privilegeIds.contains(privilegeId)) {
                BaseRolePrivilege rp = new BaseRolePrivilege();
                rp.setRoleId(roleId);
                rp.setPrivilegeId(privilegeId);
                baseRolePrivilegeMapper.insert(rp);
            }
        }
        // 依次判断 是否存在old_privilegeIds 是否存在privilegeIds，如果不存在删除
        for(long privilegeId: old_privilegeIds){
            if(!privilegeIds.contains(privilegeId)){
                // 根据privilegeId 从桥表中删除
                example.clear();
                example.createCriteria()
                        .andRoleIdEqualTo(roleId)
                        .andPrivilegeIdEqualTo(privilegeId);
                baseRolePrivilegeMapper.deleteByExample(example);
            }
        }

    }

    @Override
    public List<BaseRole> findAll() {

        return baseRoleMapper.selectByExample(new BaseRoleExample());
    }

    @Override
    public List<BaseRoleExtend> cascadePrivilegeFindAll() {
        return baseRoleExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(BaseRole baseRole) throws CustomerException {
        if(baseRole.getId()!=null){
            baseRoleMapper.updateByPrimaryKey(baseRole);
        } else {
            baseRoleMapper.insert(baseRole);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        BaseRole role = baseRoleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new CustomerException("要删除的角色不存在");
        }
        baseRoleMapper.deleteByPrimaryKey(id);
    }
}
