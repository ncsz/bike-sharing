package com.bikeshare.ncs.service;

import com.bikeshare.ncs.bean.NcsHourUsage;

import java.util.List;

public interface INcsHourUsageService {
    List<NcsHourUsage> selectHourData(Long region_id,Long day_id);
}
