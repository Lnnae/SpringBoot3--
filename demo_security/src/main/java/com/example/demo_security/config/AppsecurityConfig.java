package com.example.demo_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import java.rmi.registry.Registry;

/**
 * @author 韩伟Q
 */
@Configuration
public class AppsecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http // 1. 配置请求授权
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/static/**").permitAll() //允许所有人
                        .anyRequest().authenticated()   //剩下的请求都需要认证
                )
        //启动登陆
        //自定义登录页
        .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").
                                permitAll() // 允许所有人访问登录路径
        );

        return http.build();
    }
}
