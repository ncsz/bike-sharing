package com.bikeshare.ncs.web.controller;

import com.bikeshare.ncs.bean.Test;
import com.bikeshare.ncs.service.ITestService;
import com.bikeshare.ncs.utils.Message;
import com.bikeshare.ncs.utils.MessageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试controller类
 */
@Validated
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ITestService iTestService;
    @ApiOperation(value="查询所有文章")
    @GetMapping(value="findAll")
    public Message findAll(){
        List<Test> list=iTestService.findAll();
        return MessageUtil.success(list);
    }
    @PostMapping(value="saveOrUpdate")
    public Message saveOrUpdate(Test test){
        iTestService.saveOrUpdate(test);
        return MessageUtil.success("保存成功");
    }
}
