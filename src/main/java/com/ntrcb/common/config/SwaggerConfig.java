package com.ntrcb.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: swagger 3.0 配置
 * @Date: create in 2022/9/14 18:19
 */
@Slf4j
@EnableOpenApi
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    /**
     * api文档的详细信息函数,
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口平台内网接入")
                .version("1.0")
                .description("接口平台对接网内、专线等外部接口")
                .build();
    }
    @Bean
    public Docket docket_housing(Environment environment) {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("公积金项目")
                .enable(isOn(environment))
                .select()
                .paths(PathSelectors.ant("/housing/**"))
                .build();

    }

    /**
     * 是否开启 swagger
     * @param environment
     * @return
     */
    private static boolean isOn(Environment environment){
        Profiles profiles = Profiles.of("dev");
        return !environment.acceptsProfiles(profiles);
    }

}
