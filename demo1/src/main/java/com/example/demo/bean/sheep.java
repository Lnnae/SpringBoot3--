package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 韩伟Q
 */
@ConfigurationProperties(prefix = "sheep")
public class sheep {
    private long id;
    private String name;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "sheep{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
