package com.bikeshare.ncs.service;

import com.bikeshare.ncs.bean.extend.NcsDayUsageExtend;
import com.bikeshare.ncs.bean.extend.NcsHourUsageExtend;
import com.bikeshare.ncs.vm.dayUsage;

import java.util.List;

public interface INcsDayUsageService {

    void insertDayUsage(List<NcsDayUsageExtend> dayUsageExtends, List<NcsHourUsageExtend> hourUsageExtends);
    /**
     *某年逐月使用量
     */
    List<NcsDayUsageExtend> selectMonthDataByYear(Long id,String year);
}
