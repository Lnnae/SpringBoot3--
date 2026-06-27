package com.example.demo.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 韩伟Q
 */

@Data
public class Child {
    private String name;
    private Integer age;
    private Date birthday;
    private List<String> text;
}
