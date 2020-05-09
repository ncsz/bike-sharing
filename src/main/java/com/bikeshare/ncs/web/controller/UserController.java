package com.bikeshare.ncs.web.controller;

import com.bikeshare.ncs.bean.BaseUser;
import com.bikeshare.ncs.utils.ExcelUtils;
import com.bikeshare.ncs.utils.JwtTokenUtil;
import com.bikeshare.ncs.vm.UserVM;
import com.bikeshare.ncs.bean.extend.BaseUserExtend;
import com.bikeshare.ncs.service.IBaseUserService;
import com.bikeshare.ncs.utils.Message;
import com.bikeshare.ncs.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 /**
  * @name UserController
  * @date 2020/4/30
  * @author ncs
  * @description 用户控制器
 **/
@Validated
@RestController
@RequestMapping("/vue-element-admin/user")
public class UserController {
    @Autowired
    private IBaseUserService baseUserService;

    @PostMapping("login")
    public Message login(@RequestBody UserVM userVM){
        // 1. 认证用户的用户名和密码
        BaseUser user = baseUserService.login(userVM);
        // 2. 如果登录成功产生token,将token缓存起来，返回
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUsername());
        // 3. 如果登录失败
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return MessageUtil.success(map);
    }

    @ApiOperation(value = "通过token获取用户的基本信息")
    @GetMapping("info")
    public Message info(String token){
        // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
        long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        BaseUserExtend baseUserExtend = baseUserService.findById(id);
        return MessageUtil.success(baseUserExtend);
    }

    @PostMapping("logout")
    public Message logout(){
        // 1. 登录， token从缓存中移除掉
        return MessageUtil.success("退出成功");
    }
    @ApiOperation(value="将用户信息导入到Excel中",notes = "注意！测试的时候请将地址粘贴到浏览器的地址栏中")
    @GetMapping("download")
    public void download(HttpServletResponse response) throws Exception{
        String excelName="user_list";
        String []headList=new String []{"编号","用户姓名","电话","状态"};
        String [] fieldList=new String[]{"id","username","telephone","status"};
        List<Map<String,Object>> dataList=new ArrayList<>();
        List<BaseUser> list=baseUserService.findAll();
        for(BaseUser b:list){
            Map<String,Object> map=new HashMap<>();
            map.put("id",b.getId());
            map.put("username",b.getUsername());
            map.put("telephone",b.getTelephone());
            map.put("status",b.getStatus());
            dataList.add(map);
        }
        ExcelUtils.createExcel(response,excelName,headList,fieldList,dataList);
    }
}
