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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 /**
  * @name NcsDayUsageServiceImpl
  * @date 2020/4/30
  * @author ncs
  * @description 天使用量实现类
 **/
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
    public List<Long> selectWeekCount(Long id,String year){
        List<Long> list=new ArrayList<>();
        list.add(dayUsageExtendMapper.selectWeekendCount(id,year));
        list.add(dayUsageExtendMapper.selectWeekdayCount(id,year));
        list.add(dayUsageExtendMapper.selectHolidayCount(id,year));
        return list;
    }

    @Override
    public List<NcsDayUsageExtend> selectHolidayDetailData(Long id, String year) {
        return dayUsageExtendMapper.selectHolidayDetailData(id,year);
    }
    @Override
    public NcsDayUsage selectDataBySeason(Long id,String year,Integer season){
        return dayUsageExtendMapper.selectDataBySeason(id,year,season);
    }

     @Override
     public List<NcsDayUsage> selectAverageDataByWeekAndHoliday(Long id, String year) {
         List<NcsDayUsage> lists=new ArrayList<>();
         List<Long> list=selectWeekCount(id,year);
         NcsDayUsage ncsDayUsage1=selectWeekendData(id,year);
         ncsDayUsage1.setRegisterUsage(ncsDayUsage1.getRegisterUsage()/list.get(0));
         ncsDayUsage1.setUnregisterUsage(ncsDayUsage1.getUnregisterUsage()/list.get(0));
         ncsDayUsage1.setTotalUsage(ncsDayUsage1.getTotalUsage()/list.get(0));
         NcsDayUsage ncsDayUsage2=selectWeekdayData(id,year);
         ncsDayUsage2.setRegisterUsage(ncsDayUsage2.getRegisterUsage()/list.get(1));
         ncsDayUsage2.setUnregisterUsage(ncsDayUsage2.getUnregisterUsage()/list.get(1));
         ncsDayUsage2.setTotalUsage(ncsDayUsage2.getTotalUsage()/list.get(1));
         NcsDayUsage ncsDayUsage3=selectHolidayData(id,year);
         ncsDayUsage3.setRegisterUsage(ncsDayUsage3.getRegisterUsage()/list.get(2));
         ncsDayUsage3.setUnregisterUsage(ncsDayUsage3.getUnregisterUsage()/list.get(2));
         ncsDayUsage3.setTotalUsage(ncsDayUsage3.getTotalUsage()/list.get(2));
         lists.add(ncsDayUsage1);
         lists.add(ncsDayUsage2);
         lists.add(ncsDayUsage3);
         return lists;
     }

     @Override
     public List<NcsDayUsage> selectByWeather(Long id, String year) {
         List<NcsDayUsage> list=new ArrayList<>();
         list.add(dayUsageExtendMapper.selectByWeather(id,year,"1"));
         list.add(dayUsageExtendMapper.selectByWeather(id,year,"2"));
         list.add(dayUsageExtendMapper.selectByWeather(id,year,"3"));
         NcsDayUsage ncsDayUsage=new NcsDayUsage();
         ncsDayUsage.setRegisterUsage(0l);
         ncsDayUsage.setUnregisterUsage(0l);
         ncsDayUsage.setTotalUsage(0l);
         list.add(ncsDayUsage);
         return list;
     }

     @Override
     public List<NcsDayUsage> selectAverageByWeather(Long id, String year) {
         Long id1=dayUsageExtendMapper.selectWeatherCount(id,year,"1");
         Long id2=dayUsageExtendMapper.selectWeatherCount(id,year,"2");
         Long id3=dayUsageExtendMapper.selectWeatherCount(id,year,"3");
         Long id4=dayUsageExtendMapper.selectWeatherCount(id,year,"4");
         List<NcsDayUsage> list=new ArrayList<>();
         NcsDayUsage ncsDayUsage1=dayUsageExtendMapper.selectByWeather(id,year,"1");
         ncsDayUsage1.setRegisterUsage(ncsDayUsage1.getRegisterUsage()/id1);
         ncsDayUsage1.setUnregisterUsage(ncsDayUsage1.getUnregisterUsage()/id1);
         ncsDayUsage1.setTotalUsage(ncsDayUsage1.getTotalUsage()/id1);
         NcsDayUsage ncsDayUsage2=dayUsageExtendMapper.selectByWeather(id,year,"2");
         ncsDayUsage2.setRegisterUsage(ncsDayUsage2.getRegisterUsage()/id2);
         ncsDayUsage2.setUnregisterUsage(ncsDayUsage2.getUnregisterUsage()/id2);
         ncsDayUsage2.setTotalUsage(ncsDayUsage2.getTotalUsage()/id2);
         NcsDayUsage ncsDayUsage3=dayUsageExtendMapper.selectByWeather(id,year,"3");
         ncsDayUsage3.setRegisterUsage(ncsDayUsage3.getRegisterUsage()/id3);
         ncsDayUsage3.setUnregisterUsage(ncsDayUsage3.getUnregisterUsage()/id3);
         ncsDayUsage3.setTotalUsage(ncsDayUsage3.getTotalUsage()/id3);
         NcsDayUsage ncsDayUsage4=dayUsageExtendMapper.selectByWeather(id,year,"4");
//         ncsDayUsage4.setRegisterUsage(ncsDayUsage4.getRegisterUsage()/id4);
//         ncsDayUsage4.setUnregisterUsage(ncsDayUsage4.getUnregisterUsage()/id4);
//         ncsDayUsage4.setTotalUsage(ncsDayUsage4.getTotalUsage()/id4);
         NcsDayUsage ncsDayUsage=new NcsDayUsage();
         ncsDayUsage.setRegisterUsage(0l);
         ncsDayUsage.setUnregisterUsage(0l);
         ncsDayUsage.setTotalUsage(0l);
         list.add(ncsDayUsage1);
         list.add(ncsDayUsage2);
         list.add(ncsDayUsage3);
         if(ncsDayUsage4==null){
             list.add(ncsDayUsage);
         }else {
             list.add(ncsDayUsage4);
         }
         return list;
     }
     @Override
     public List<NcsDayUsageExtend> selectByTemperature(Long id,String year){
        double count1=-4,count2=0;
        List<NcsDayUsageExtend> list=new ArrayList<>();
        while(count1<41&&count2<45){
            NcsDayUsageExtend dayUsageExtend1=dayUsageExtendMapper.selectByTemperature(id,year,count1-0.01,count2+0.99);
            if(dayUsageExtend1==null){
                NcsDayUsageExtend dayUsageExtend=new NcsDayUsageExtend();
                dayUsageExtend.setRegisterUsage(0l);
                dayUsageExtend.setUnregisterUsage(0l);
                dayUsageExtend.setTotalUsage(0l);
                dayUsageExtend.setTem(Integer.toString((int)count1)+"-"+Integer.toString((int)count2));
                list.add(dayUsageExtend);
            }
            else {
                dayUsageExtend1.setTem(Integer.toString((int)count1)+"-"+Integer.toString((int)count2));
                list.add(dayUsageExtend1);
            }
            count1=count1+5;
            count2=count2+5;
        }
        return list;
     }
 }
