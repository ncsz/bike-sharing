package com.bikeshare.ncs.config;

import com.bikeshare.ncs.bean.BasePrivilege;
import com.bikeshare.ncs.service.IBasePrivilegeService;
import com.bikeshare.ncs.utils.JwtTokenUtil;
import com.bikeshare.ncs.utils.PermissionException;
import com.bikeshare.ncs.utils.UnAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 /**
  * @name JwtInterceptor
  * @date 2020/4/30
  * @author ncs
  * @description 判断token以及权限拦截器
 **/

public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IBasePrivilegeService basePrivilegeService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果是options请求，直接返回true，不进行拦截
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        // 获取请求头信息authorization信息
        final String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        //final String token=request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            throw new UnAuthorizedException("用户还未登录");
        }
         //验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        JwtTokenUtil.parseJWT(token, JwtTokenUtil.base64Secret);

         //验证权限，通过token获取用户id，通过用户id获取权限，这里可以使用redis将用户信息维护在缓存中，减少与数据库交互次数
        //long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        //this.auth(id,request.getServletPath());

        return true;
    }

    // 判断权限
    private boolean auth(long userId,String path){
        // article/findAll
        // 查询出该用户的所有权限
        List<BasePrivilege> privileges = basePrivilegeService.findByUserId(userId);
        // 匹配
        for(BasePrivilege p : privileges){
            System.out.println(p.getRoute()+"="+path);
            if(p.getRoute().matches(path)){
                return true;
            }
        }
        throw new PermissionException("权限不足");
    }
}
