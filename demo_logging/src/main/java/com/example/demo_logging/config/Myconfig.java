package com.example.demo_logging.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;

/**
 * @author 韩伟Q
 */
@Configuration

public class Myconfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //保留以前规则
        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry.addResourceHandler("/static/**")
                .setCacheControl(CacheControl.maxAge(1170, TimeUnit.MILLISECONDS));
    }
}
