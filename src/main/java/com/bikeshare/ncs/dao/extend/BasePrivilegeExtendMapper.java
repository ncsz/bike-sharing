package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.BasePrivilege;
import com.bikeshare.ncs.vm.PrivilegeTree;

import java.util.List;

public interface BasePrivilegeExtendMapper {
    List<PrivilegeTree> selectAll();

    List<BasePrivilege> selectByParentId(long id);

    List<BasePrivilege> selectByRoleId(long id);

    List<BasePrivilege> selectByUserId(long id);

    List<BasePrivilege> selectMenuByUserId(long id);
}
