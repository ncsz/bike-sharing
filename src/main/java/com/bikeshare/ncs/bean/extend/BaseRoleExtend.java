package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.BasePrivilege;
import com.bikeshare.ncs.bean.BaseRole;

import java.util.List;

 /**
  * @name BaseRoleExtend
  * @date 2020/4/30
  * @author ncs
  * @description 角色拓展类
 **/

public class BaseRoleExtend extends BaseRole {
    private List<BasePrivilege> privileges;

    public List<BasePrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<BasePrivilege> privileges) {
        this.privileges = privileges;
    }
}
