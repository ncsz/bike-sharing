package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.extend.BaseUserExtend;

import java.util.List;

public interface BaseUserExtendMapper {
    BaseUserExtend selectById(long id);
    List<BaseUserExtend> selectAll();
}
