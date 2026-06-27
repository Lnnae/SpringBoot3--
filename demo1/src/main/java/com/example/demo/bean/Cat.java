package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 韩伟Q
 */
@Data
@ConfigurationProperties(prefix = "cat")
public class Cat {
    private Integer age;
    private String name;
}
