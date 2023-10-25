package com.ntrcb;

import com.hb0730.commons.spring.SpringContextUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 */
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = {"com.ntrcb.common.mapper"})
public class ImmovableApplication extends SpringBootServletInitializer {
    public static void main( String[] args ) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ImmovableApplication.class, args);
        SpringContextUtils.setApplicationContext(applicationContext);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ImmovableApplication.class);
    }
}
