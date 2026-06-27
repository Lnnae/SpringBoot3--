package com.example.demo_logging.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 韩伟Q
 */
@AllArgsConstructor     //所有的参数都可以调用
//@Component
@Data
@NoArgsConstructor      //无参的都可调用
public class person {
    private Long id;
    private String userName;
    private String email;
    private Integer age;
    private String role;
}
