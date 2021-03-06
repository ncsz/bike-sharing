package com.bikeshare.ncs.dao.extend;

import com.bikeshare.ncs.bean.NcsDayUsage;
import com.bikeshare.ncs.bean.extend.NcsDayUsageExtend;

import java.util.List;
 /**
  * @name NcsDayUsageExtendMapper
  * @date 2020/4/30
  * @author ncs
  * @description 天使用量mapper扩展
 **/
public interface NcsDayUsageExtendMapper {
    List<NcsDayUsageExtend> selectMonthDataByYear(Long id,String year);
    List<NcsDayUsageExtend> selectDayDataByYearAndMonth(Long id,String year,String month);
    NcsDayUsage selectWeekendData(Long id,String year);
    NcsDayUsage selectWeekdayData(Long id,String year);
    NcsDayUsage selectHolidayData(Long id,String year);
    Long selectWeekendCount(Long id,String year);
    Long selectWeekdayCount(Long id,String year);
    Long selectHolidayCount(Long id,String year);
    List<NcsDayUsageExtend> selectHolidayDetailData(Long id,String year);
    NcsDayUsage selectDataBySeason(Long id,String year,Integer season);
    NcsDayUsage selectByWeather(Long id,String year,String weather);
    Long selectWeatherCount(Long id,String year,String weather);
    NcsDayUsageExtend selectByTemperature(Long id,String year,Double tem1,Double tem2);
}
