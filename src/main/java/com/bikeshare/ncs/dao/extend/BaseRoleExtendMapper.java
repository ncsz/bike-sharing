package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.BaseUser;
import com.bikeshare.ncs.bean.extend.BaseRoleExtend;

import java.util.List;
 /**
  * @name BaseRoleExtendMapper
  * @date 2020/4/30
  * @author ncs
  * @description 角色mapper扩展
 **/
public interface BaseRoleExtendMapper {
    List<BaseUser> selectByUserId(long id);
    List<BaseRoleExtend> selectAll();
}
