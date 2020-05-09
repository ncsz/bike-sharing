package com.bikeshare.ncs.vm;

import com.bikeshare.ncs.bean.BasePrivilege;

import java.util.List;

 /**
  * @name PrivilegeTree
  * @date 2020/4/30
  * @author ncs
  * @description 权限树
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
