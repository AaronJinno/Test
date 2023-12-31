package com.sgugo.openapi.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                // .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .groupName("admin")
                .select()
                // 方式一: 配置扫描 所有想在swagger界面的统一管理接口，都必须在此包下
               .apis(RequestHandlerSelectors.basePackage("com.sgugo.openapi.admin"))
               //  .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                // 方式二: 只有当方法上有  @ApiOperation 注解时才能生成对应的接口文档
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .groupName("client")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sgugo.openapi.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Aaron","https://www.sgugo.com","aaronjinno@gmail.com");
        return new ApiInfoBuilder()
                .title("hello")
                .description("# XXX项目API接口文档简介")
                .termsOfServiceUrl("http://127.0.0.1/#/login")
                .contact(new Contact("fangqi", "", "fang_qi170@126.com"))

                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }
}
