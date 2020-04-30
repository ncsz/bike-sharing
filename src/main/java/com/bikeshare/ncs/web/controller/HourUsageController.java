package com.bikeshare.ncs.web.controller;

import com.bikeshare.ncs.bean.NcsHourUsage;
import com.bikeshare.ncs.service.INcsHourUsageService;
import com.bikeshare.ncs.utils.Message;
import com.bikeshare.ncs.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/hourUsage")
public class HourUsageController {
    @Autowired
    private INcsHourUsageService hourUsageService;
    @PostMapping("/selectHourData")
    public Message selectHourData(Long region_id, Long day_id){
        List<NcsHourUsage>list= hourUsageService.selectHourData(region_id,day_id);
        return MessageUtil.success(list);
    }
}
