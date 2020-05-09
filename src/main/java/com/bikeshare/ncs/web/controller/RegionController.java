package com.bikeshare.ncs.web.controller;

import com.bikeshare.ncs.bean.NcsRegions;
import com.bikeshare.ncs.bean.extend.NcsRegionsExtend;
import com.bikeshare.ncs.service.INcsRegionsService;
import com.bikeshare.ncs.utils.Message;
import com.bikeshare.ncs.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
 /**
  * @name RegionController
  * @date 2020/4/30
  * @author ncs
  * @description 区域控制器
 **/
@Validated
@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private INcsRegionsService regionsService;
//    @PostMapping("findAllRegion")
//    public List<NcsRegions> findAllProvince(){
//        return regionsService.findAll();
//    }
    @GetMapping("selectAllRegion")
    public Message selectAllRegion(){
        List<NcsRegionsExtend> list=regionsService.selectAll();
        return MessageUtil.success(list);
    }
}
