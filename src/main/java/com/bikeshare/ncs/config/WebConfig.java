package com.bikeshare.ncs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 /**
  * @name WebConfig
  * @date 2020/4/30
  * @author ncs
  * @description web配置信息，重写了拦截器规则
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径可自行配置多个 可用 ，分隔开
        registry.addInterceptor(jwtInterceptor())
//				.addPathPatterns("/category/**","/article/**","/user/**","/role/**","/privilege/**")
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/swagger-resources/**","/v2/**","/swagger-ui.html","/webjars/**",
                        "/vue-element-admin/user/login","/vue-element-admin/user/logout","/vue-element-admin/user/info"
                        ,"/privilege/findPrivilegeTree","/vue-element-admin/user/download"
                        ,"/baseUser/findMenuByUserId","dayUsage/putDataToDayUsage");
    }
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
