package com.bikeshare.ncs.service;

import com.bikeshare.ncs.bean.NcsDayUsage;
import com.bikeshare.ncs.bean.extend.NcsDayUsageExtend;
import com.bikeshare.ncs.bean.extend.NcsHourUsageExtend;

import java.util.List;

public interface INcsDayUsageService {

    void insertDayUsage(List<NcsDayUsageExtend> dayUsageExtends, List<NcsHourUsageExtend> hourUsageExtends);
    /**
     *某年逐月使用量
     */
    List<NcsDayUsageExtend> selectMonthDataByYear(Long id,String year);
    List<NcsDayUsageExtend> selectDayDataByYearAndMonth(Long id,String year,String month);
    NcsDayUsage selectWeekendData(Long id,String year);
    NcsDayUsage selectWeekdayData(Long id,String year);
    NcsDayUsage selectHolidayData(Long id,String year);
    List<Long> selectWeekCount(Long id,String year);
    List<NcsDayUsageExtend> selectHolidayDetailData(Long id,String year);
    NcsDayUsage selectDataBySeason(Long id,String year,Integer season);
    List<NcsDayUsage> selectAverageDataByWeekAndHoliday(Long id,String year);
    List<NcsDayUsage> selectByWeather(Long id,String year);
    List<NcsDayUsage> selectAverageByWeather(Long id,String year);
    List<NcsDayUsageExtend> selectByTemperature(Long id,String year);
}
