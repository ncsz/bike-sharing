package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.NcsHourUsage;

import java.util.List;

public interface NcsHourUsageExtendMapper {
    List<NcsHourUsage> selectHourData(Long region_id,Long day_id);
}
