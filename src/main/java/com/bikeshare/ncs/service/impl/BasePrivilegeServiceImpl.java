package com.bikeshare.ncs.service.impl;

import com.bikeshare.ncs.bean.BasePrivilege;
import com.bikeshare.ncs.bean.BasePrivilegeExample;
import com.bikeshare.ncs.dao.BasePrivilegeMapper;
import com.bikeshare.ncs.dao.extend.BasePrivilegeExtendMapper;
import com.bikeshare.ncs.service.IBasePrivilegeService;
import com.bikeshare.ncs.utils.CustomerException;
import com.bikeshare.ncs.vm.PrivilegeTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 权限控制实现类
 * @author: charles
 * @create: 2019-11-16 15:54
 **/
@Service
public class BasePrivilegeServiceImpl implements IBasePrivilegeService {
    @Resource
    private BasePrivilegeMapper basePrivilegeMapper;
    @Resource
    private BasePrivilegeExtendMapper basePrivilegeExtendMapper;

    @Override
    public List<BasePrivilege> findByUserId(long id) {
        return basePrivilegeExtendMapper.selectByUserId(id);
    }

    @Override
    public List<BasePrivilege> findAll() {
        return basePrivilegeMapper.selectByExample(new BasePrivilegeExample());
    }

    @Override
    public void saveOrUpdate(BasePrivilege privilege) throws CustomerException {
        if(privilege.getId()!=null){
            basePrivilegeMapper.updateByPrimaryKey(privilege);
        } else {
            basePrivilegeMapper.insert(privilege);
        }
    }

    @Override
    public List<BasePrivilege> findByParentId(Long parentId) {
        BasePrivilegeExample example = new BasePrivilegeExample();
        if(parentId == null){
            example.createCriteria().andParentIdIsNull();
        } else {
            example.createCriteria().andParentIdEqualTo(parentId);
        }
        return basePrivilegeMapper.selectByExample(example);
    }

    @Override
    public List<PrivilegeTree> findPrivilegeTree() {
        return basePrivilegeExtendMapper.selectAll();
    }

    @Override
    public List<BasePrivilege> findMenuByUserId(long id) {
        return basePrivilegeExtendMapper.selectMenuByUserId(id);
    }
}
