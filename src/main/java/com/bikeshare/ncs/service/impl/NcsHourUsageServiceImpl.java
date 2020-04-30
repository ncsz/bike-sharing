package com.bikeshare.ncs.service.impl;

import com.bikeshare.ncs.bean.NcsHourUsage;
import com.bikeshare.ncs.dao.extend.NcsHourUsageExtendMapper;
import com.bikeshare.ncs.service.INcsHourUsageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class NcsHourUsageServiceImpl implements INcsHourUsageService {
    @Resource
    private NcsHourUsageExtendMapper hourUsageExtendMapper;
    @Override
    public List<NcsHourUsage> selectHourData(Long region_id, Long day_id) {
        return hourUsageExtendMapper.selectHourData(region_id,day_id);
    }
}
