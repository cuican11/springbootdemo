package com.hwgif.swagger;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lc.huang on 2019/11/18.
 * Description
 */
@EnableWebMvc //NOTE: Only needed in a non-springboot application
@EnableSwagger2 //Enable swagger 2.0 spec
public class SwaggerConfig {


    //demo接口
    @Bean
    public Docket apiForDemo() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("hwgifDemoApi")
                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.hwgif.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfoForDemo());
    }


    //demo接口说明
    private ApiInfo apiInfoForDemo() {
        return new ApiInfoBuilder()
                .title("demo接口")
                .description("demo接口，当前数据为MOCK数据")
                .version("1.0.0")
                .termsOfServiceUrl("http://xxx.xxx.com")
                .license("LICENSE")
                .licenseUrl("http://xxx.xxx.com")
                .build();
    }





}
