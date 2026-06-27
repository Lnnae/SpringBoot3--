package com.example.demo.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 韩伟Q
 */
@Component
@ConfigurationProperties(prefix = "person")
@Data   //就相当于自动有了get和set的方法
public class Person {
    private String name;
    private Integer age;
    private Date birthday;
    private boolean like;
    private Child child;
    private List<Dog> dogs;
    private Map<String, Cat> cats;
}
