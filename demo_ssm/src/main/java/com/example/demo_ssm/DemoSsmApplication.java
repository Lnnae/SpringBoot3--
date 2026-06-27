package com.example.demo_ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo_ssm.mapper") // <--- 指向你 Mapper 接口所在的包
@SpringBootApplication
public class DemoSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSsmApplication.class, args);
    }

}
