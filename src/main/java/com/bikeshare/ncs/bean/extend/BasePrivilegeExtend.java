package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.BasePrivilege;

import java.util.List;

 /**
  * @name BasePrivilegeExtend
  * @date 2020/4/30
  * @author ncs
  * @description 权限拓展
 **/
public class BasePrivilegeExtend extends BasePrivilege {
    private List<BasePrivilege> children;

    public List<BasePrivilege> getChildren() {
        return children;
    }

    public void setChildren(List<BasePrivilege> children) {
        this.children = children;
    }
}
