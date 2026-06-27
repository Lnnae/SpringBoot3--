package com.example.demo_security.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 韩伟Q
 */
@RestController
public class hello {
    @GetMapping("/hello")
    public String hello(){

        return "hello";

    }
    @GetMapping("/pick")
    public String pick(){

        return "hellow";

    }
}
