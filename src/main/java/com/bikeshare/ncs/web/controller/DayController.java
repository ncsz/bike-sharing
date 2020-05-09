package com.bikeshare.ncs.web.controller;

import com.bikeshare.ncs.service.INcsDayService;
import com.bikeshare.ncs.utils.Message;
import com.bikeshare.ncs.utils.MessageUtil;
import com.bikeshare.ncs.vm.Day;
import com.bikeshare.ncs.vm.Year;
import com.bikeshare.ncs.vm.YearAndMonth;
import com.bikeshare.ncs.vm.YearMonthAndDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
 /**
  * @name DayController
  * @date 2020/4/30
  * @author ncs
  * @description 天控制类
 **/
@Validated
@RestController
@RequestMapping("/day")
public class DayController {
    @Autowired
    private INcsDayService dayService;
    @PostMapping("years")
    public Message selectYears(){
        List<Year> list=dayService.selectYears();
        return MessageUtil.success(list);
    }
    @PostMapping("yearsAndMonths")
    public Message selectYearsAndMonths(){
        List<YearAndMonth> list=dayService.selectYearsAndMonths();
        return MessageUtil.success(list);
    }
    @PostMapping("yearsMonthsAndDays")
    public Message selectYearsMonthsAndDays(){
        List<YearMonthAndDay> list=dayService.selectYearsMonthsAndDays();
        return MessageUtil.success(list);
    }
     /**
      * 1: 晴朗、飘着几朵云、局部多云
      * 2: 薄雾加多云、薄雾加碎云、薄雾加几朵云、薄雾
      * 3: 小雪、小雨加雷暴加散云、小雨加散云
      * 4: 大雨加冰雹加雷暴加薄雾、下雪加雾
      */
 }
