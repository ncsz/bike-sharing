package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.BaseUser;
import com.bikeshare.ncs.bean.extend.BaseRoleExtend;

import java.util.List;

public interface BaseRoleExtendMapper {
    List<BaseUser> selectByUserId(long id);
    List<BaseRoleExtend> selectAll();
}
