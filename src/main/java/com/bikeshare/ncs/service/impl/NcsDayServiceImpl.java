package com.bikeshare.ncs.service.impl;

import com.bikeshare.ncs.dao.extend.NcsDayExtendMapper;
import com.bikeshare.ncs.service.INcsDayService;
import com.bikeshare.ncs.vm.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class NcsDayServiceImpl implements INcsDayService {
    @Resource
    private NcsDayExtendMapper dayExtendMapper;
    @Override
    public List<Year> selectYears() {
        return dayExtendMapper.selectYears();
    }

    @Override
    public List<YearAndMonth> selectYearsAndMonths() {
        return dayExtendMapper.selectYearsAndMonths();
    }

    @Override
    public List<YearMonthAndDay> selectYearsMonthsAndDays() {
        List<YearMonthAndDay> yearMonthAndDays=new ArrayList<>();
        List<YearAndMonth> yearAndMonths=selectYearsAndMonths();
        Iterator<YearAndMonth> iterator=yearAndMonths.iterator();
        while (iterator.hasNext()){
            YearAndMonth yearAndMonth=iterator.next();
            String year=yearAndMonth.getYear();
            List<Month> months=yearAndMonth.getChildren();
            List<MonthAndDay> monthAndDays=new ArrayList<>();
            Iterator<Month> iterator1=months.iterator();
            while (iterator1.hasNext()){
                String month=iterator1.next().getYear();
                List<Day> days=dayExtendMapper.selectDays(year,month);
                MonthAndDay monthAndDay=new MonthAndDay();
                monthAndDay.setYear(month);
                monthAndDay.setChildren(days);
                monthAndDays.add(monthAndDay);
            }
            YearMonthAndDay yearMonthAndDay=new YearMonthAndDay();
            yearMonthAndDay.setYear(year);
            yearMonthAndDay.setChildren(monthAndDays);
            yearMonthAndDays.add(yearMonthAndDay);
        }
        return yearMonthAndDays;
    }
}
