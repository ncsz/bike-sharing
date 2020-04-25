package com.bikeshare.ncs.service;

import com.bikeshare.ncs.bean.BasePrivilege;
import com.bikeshare.ncs.utils.CustomerException;
import com.bikeshare.ncs.vm.PrivilegeTree;

import java.util.List;

public interface IBasePrivilegeService {
    
    /** 
     * @Description: 查询所有权限 
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege> 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    List<BasePrivilege> findAll();
    
    /** 
     * @Description: 通过parentId查询权限
     * @Param: [parentId] 
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege> 
     * @Author: charles 
     * @Date: 2019-11-17 
     */ 
    List<BasePrivilege> findByParentId(Long parentId);
    
    /** 
     * @Description: 保存或更新权限 
     * @Param: [privilege] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    void saveOrUpdate(BasePrivilege privilege) throws CustomerException;

    /** 
     * @Description: 查询权限树 
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.cms.vm.PrivilegeTree> 
     * @Author: charles 
     * @Date: 2019-11-18 
     */ 
    List<PrivilegeTree> findPrivilegeTree();
    
    /** 
     * @Description: 查询用户所有权限 
     * @Param: [id] 
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege> 
     * @Author: charles 
     * @Date: 2019-11-18 
     */ 
    List<BasePrivilege> findByUserId(long id);

    /**
     * @Description: 查询用户所有菜单
     * @Param: [id]
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege>
     * @Author: charles
     * @Date: 2019-11-18
     */
    List<BasePrivilege> findMenuByUserId(long id);

}
