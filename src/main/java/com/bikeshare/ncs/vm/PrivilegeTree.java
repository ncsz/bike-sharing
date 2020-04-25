package com.bikeshare.ncs.vm;

import com.bikeshare.ncs.bean.BasePrivilege;

import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 权限树
 * @author: charles
 * @create: 2019-11-17 20:09
 **/

public class PrivilegeTree extends BasePrivilege {
    private List<BasePrivilege> children;

    public List<BasePrivilege> getChildren() {
        return children;
    }

    public void setChildren(List<BasePrivilege> children) {
        this.children = children;
    }
}
