package com.bikeshare.ncs.web.controller;

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
}
