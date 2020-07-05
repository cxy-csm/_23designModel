package com.qf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .groupName("yangl")
                .enable(true)//开启Swagger
                .select()//指定扫描包
                .apis(RequestHandlerSelectors.basePackage("com.qf.controller"))
                .build();
    }

    @Bean
    public Docket createDocket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .groupName("jack")  //用户或项目组名称
                .enable(true); //是否开启
    }

    //@Bean
    public ApiInfo createApiInfo(){
        return new ApiInfoBuilder()
                .title("网易云音乐")
                .description("网易云音乐接口文档描述")
                //.termsOfServiceUrl("http://www.baidu.com")  可以跳转的网址
                .build();
    }
}
