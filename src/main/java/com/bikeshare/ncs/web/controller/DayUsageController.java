package com.bikeshare.ncs.web.controller;

import com.bikeshare.ncs.bean.NcsDayUsage;
import com.bikeshare.ncs.bean.extend.NcsDayUsageExtend;
import com.bikeshare.ncs.bean.extend.NcsHourUsageExtend;
import com.bikeshare.ncs.service.INcsDayUsageService;
import com.bikeshare.ncs.utils.CsvUtil;
import com.bikeshare.ncs.utils.Message;
import com.bikeshare.ncs.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/dayUsage")
public class DayUsageController {
    @Autowired
    private INcsDayUsageService dayUsageService;
    @GetMapping("putDataToDayUsage")
    public void insertDayUsage() throws Exception {
        //File file=new File("D:/day.csv");
        //List<List<Object>> list=ExcelUtils.readExcel(file);
        //MessageUtil.success(list);
        List<NcsDayUsageExtend> list=CsvUtil.ConvertDayCsvToList();
        List<NcsHourUsageExtend> list1=CsvUtil.ConvertHourCsvToList();
        //dayUsageService.insertDayUsage(list,list1);
    }
    @PostMapping("selectMonthDataByYear")
    public Message selectMonthDataByYear(@NotNull Long id, @NotNull String year){
        List<NcsDayUsageExtend> list=dayUsageService.selectMonthDataByYear(id,year);
        return MessageUtil.success(list);
    }
    @PostMapping("selectDayDataByYearAndMonth")
    public Message selectDayDataByYearAndMonth(long id,String year,String month){
        List<NcsDayUsageExtend> list=dayUsageService.selectDayDataByYearAndMonth(id,year,month);
        return MessageUtil.success(list);
    }
    @PostMapping("selectDataByWeekAndHoliday")
    public Message selectDataByWeekAndHoliday(Long id,String year){
        List<NcsDayUsage> list=new ArrayList<>();
        NcsDayUsage ncsDayUsage1=dayUsageService.selectWeekendData(id,year);
        NcsDayUsage ncsDayUsage2=dayUsageService.selectWeekdayData(id,year);
        NcsDayUsage ncsDayUsage3=dayUsageService.selectHolidayData(id,year);
        list.add(ncsDayUsage1);
        list.add(ncsDayUsage2);
        list.add(ncsDayUsage3);
        return MessageUtil.success(list);
    }
    @PostMapping("selectWeekCount")
    public Message selectWeekCount(Long id,String year){
        List<Long> list=new ArrayList<>();
        list.add(dayUsageService.selectWeekendCount(id,year));
        list.add(dayUsageService.selectWeekdayCount(id,year));
        list.add(dayUsageService.selectHolidayCount(id,year));
        return MessageUtil.success(list);
    }
    @PostMapping("selectHolidayDetailData")
    public Message selectHolidayDetailData(Long id,String year){
        List<NcsDayUsageExtend> list=dayUsageService.selectHolidayDetailData(id,year);
        return MessageUtil.success(list);
    }
    @PostMapping("selectDataBySeason")
    public Message selectDataBySeason(Long id,String year){
        List<NcsDayUsage> list=new ArrayList<>();
        NcsDayUsage dayUsage1=dayUsageService.selectDataBySeason(id,year,1);
        NcsDayUsage dayUsage2=dayUsageService.selectDataBySeason(id,year,2);
        NcsDayUsage dayUsage3=dayUsageService.selectDataBySeason(id,year,3);
        NcsDayUsage dayUsage4=dayUsageService.selectDataBySeason(id,year,4);
        list.add(dayUsage1);
        list.add(dayUsage2);
        list.add(dayUsage3);
        list.add(dayUsage4);
        return MessageUtil.success(list);
    }
}
