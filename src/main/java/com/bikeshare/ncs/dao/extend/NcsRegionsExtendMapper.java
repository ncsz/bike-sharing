package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.NcsRegions;
import com.bikeshare.ncs.bean.extend.NcsRegionsExtend;

import java.util.List;
 /**
  * @name NcsRegionsExtendMapper
  * @date 2020/4/30
  * @author ncs
  * @description 区域mapper扩展
 **/
public interface NcsRegionsExtendMapper {
    List<NcsRegionsExtend> selectAll();
    List<NcsRegions> findByParentId(long id);
}
