package com.example.demo_ssm.controller;

import com.example.demo_ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 韩伟Q
 */
@RestController  // <--- 必须加这个！
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    public TUser getUser(@PathVariable("id") long id){
        return userMapper.getUserById(id);
    }
}
