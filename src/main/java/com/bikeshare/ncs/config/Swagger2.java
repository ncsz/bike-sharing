package com.bikeshare.ncs.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 /**
  * @name Swagger2
  * @date 2020/4/30
  * @author ncs
  * @description swagger配置信息，用于后台测试
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bikeshare.ncs.web"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("共享单车需求预测")
                .description("预测未来贡献单车的需求量：http://www.baidu.com/")
                .termsOfServiceUrl("http://www.baidu.com/")
                .contact("ncs")
                .version("1.0")
                .build();
    }
    private ApiKey apiKey(){
        return new ApiKey("Authorization","Authorization","header");
    }
}
