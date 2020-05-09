package com.bikeshare.ncs.bean.extend;

import com.bikeshare.ncs.bean.BaseRole;
import com.bikeshare.ncs.bean.BaseUser;

import java.util.List;
 /**
  * @name BaseUserExtend
  * @date 2020/4/30
  * @author ncs
  * @description 用户拓展
 **/
public class BaseUserExtend extends BaseUser {
    public static final String STATUS_NORMAL="正常";
    public static final String STATUS_FORBIDDEN="禁用";

    private List<BaseRole> roles;

    public List<BaseRole> getRoles() {
        return roles;
    }

    public void setRoles(List<BaseRole> roles) {
        this.roles = roles;
    }
}
