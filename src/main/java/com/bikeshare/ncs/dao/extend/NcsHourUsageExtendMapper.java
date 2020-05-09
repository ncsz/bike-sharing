package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.NcsHourUsage;

import java.util.List;
 /**
  * @name NcsHourUsageExtendMapper
  * @date 2020/4/30
  * @author ncs
  * @description 小时使用量mapper扩展
 **/
public interface NcsHourUsageExtendMapper {
    List<NcsHourUsage> selectHourData(Long region_id,Long day_id);
}
