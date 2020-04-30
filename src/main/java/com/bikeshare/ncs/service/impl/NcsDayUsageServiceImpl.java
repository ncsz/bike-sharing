package com.bikeshare.ncs.service.impl;

import com.bikeshare.ncs.bean.NcsDay;
import com.bikeshare.ncs.bean.NcsDayUsage;
import com.bikeshare.ncs.bean.NcsHourUsage;
import com.bikeshare.ncs.bean.extend.NcsDayUsageExtend;
import com.bikeshare.ncs.bean.extend.NcsHourUsageExtend;
import com.bikeshare.ncs.dao.NcsDayMapper;
import com.bikeshare.ncs.dao.NcsDayUsageMapper;
import com.bikeshare.ncs.dao.NcsHourUsageMapper;
import com.bikeshare.ncs.dao.extend.NcsDayUsageExtendMapper;
import com.bikeshare.ncs.service.INcsDayUsageService;
import com.bikeshare.ncs.vm.dayUsage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class NcsDayUsageServiceImpl implements INcsDayUsageService {
    @Resource
    private NcsDayMapper dayMapper;
    @Resource
    private NcsDayUsageMapper dayUsageMapper;
    @Resource
    private NcsHourUsageMapper hourUsageMapper;
    @Resource
    private NcsDayUsageExtendMapper dayUsageExtendMapper;

    @Override
    public void insertDayUsage(List<NcsDayUsageExtend> dayUsageExtends, List<NcsHourUsageExtend> hourUsageExtends) {
        Iterator<NcsDayUsageExtend> iterator=dayUsageExtends.iterator();
        Iterator<NcsHourUsageExtend> iterator1=hourUsageExtends.iterator();
        while(iterator.hasNext()){
            NcsDayUsageExtend dayUsageExtend=iterator.next();
            NcsDay day=new NcsDay();
            day.setYear(dayUsageExtend.getDays().getYear());
            day.setMonth(dayUsageExtend.getDays().getMonth());
            day.setDay(dayUsageExtend.getDays().getDay());
            day.setWeek(dayUsageExtend.getDays().getWeek());
            day.setHoliday(dayUsageExtend.getDays().getHoliday());
            day.setSeason(dayUsageExtend.getDays().getSeason());
            day.setWeather(dayUsageExtend.getDays().getWeather());
            dayMapper.insert(day);
            long id=day.getId();
            NcsDayUsage dayUsage=new NcsDayUsage();
            dayUsage.setBikeinfoId(1l);
            dayUsage.setRegionId(284l);
            dayUsage.setDayId(id);
            dayUsage.setTemperature(dayUsageExtend.getTemperature());
            dayUsage.setRegisterUsage(dayUsageExtend.getRegisterUsage());
            dayUsage.setUnregisterUsage(dayUsageExtend.getUnregisterUsage());
            dayUsage.setTotalUsage(dayUsageExtend.getTotalUsage());
            dayUsageMapper.insert(dayUsage);
            while (iterator1.hasNext()){
                NcsHourUsageExtend hourUsageExtend=iterator1.next();
                NcsHourUsage hourUsage=new NcsHourUsage();
                hourUsage.setBikeinfoId(1l);
                hourUsage.setRegionId(284l);
                hourUsage.setDayId(id);
                hourUsage.setHour(hourUsageExtend.getHour());
                hourUsage.setTemperature(hourUsageExtend.getTemperature());
                hourUsage.setRegisterUsage(hourUsageExtend.getRegisterUsage());
                hourUsage.setUnregisterUsage(hourUsageExtend.getUnregisterUsage());
                hourUsage.setTotalUsage(hourUsageExtend.getTotalUsage());
                hourUsageMapper.insert(hourUsage);
                if(hourUsageExtend.getHour().equals(23)||
                        (hourUsageExtend.getHour().equals(17)&&hourUsageExtend.getDays().getYear().equals("2011")&&hourUsageExtend.getDays().getMonth().equals("08")&&hourUsageExtend.getDays().getDay().equals("27"))){
                    break;
                }
            }
        }
    }

    @Override
    public List<NcsDayUsageExtend> selectMonthDataByYear(Long id,String year) {
        List<NcsDayUsageExtend> list=dayUsageExtendMapper.selectMonthDataByYear(id,year);
        return list;
    }

    @Override
    public List<NcsDayUsageExtend> selectDayDataByYearAndMonth(Long id, String year, String month) {
        return dayUsageExtendMapper.selectDayDataByYearAndMonth(id,year,month);
    }

    @Override
    public NcsDayUsage selectWeekendData(Long id, String year) {
        return dayUsageExtendMapper.selectWeekendData(id,year);
    }

    @Override
    public NcsDayUsage selectWeekdayData(Long id, String year) {
        return dayUsageExtendMapper.selectWeekdayData(id,year);
    }

    @Override
    public NcsDayUsage selectHolidayData(Long id, String year) {
        return dayUsageExtendMapper.selectHolidayData(id,year);
    }

    @Override
    public Long selectWeekendCount(Long id, String year) {
        return dayUsageExtendMapper.selectWeekendCount(id,year);
    }

    @Override
    public Long selectWeekdayCount(Long id, String year) {
        return dayUsageExtendMapper.selectWeekdayCount(id,year);
    }

    @Override
    public Long selectHolidayCount(Long id, String year) {
        return dayUsageExtendMapper.selectHolidayCount(id,year);
    }

    @Override
    public List<NcsDayUsageExtend> selectHolidayDetailData(Long id, String year) {
        return dayUsageExtendMapper.selectHolidayDetailData(id,year);
    }
    @Override
    public NcsDayUsage selectDataBySeason(Long id,String year,Integer season){
        return dayUsageExtendMapper.selectDataBySeason(id,year,season);
    }
}
