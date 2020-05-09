package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.extend.BaseUserExtend;

import java.util.List;
 /**
  * @name BaseUserExtendMapper
  * @date 2020/4/30
  * @author ncs
  * @description 用户mapper扩展
 **/
public interface BaseUserExtendMapper {
    BaseUserExtend selectById(long id);
    List<BaseUserExtend> selectAll();
}
