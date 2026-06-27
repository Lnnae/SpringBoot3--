package com.example.demo.springboots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 韩伟Q
 */
@RestController
public class application {

        @GetMapping("/hello")
        public String hello()
        {
            return "Hello, Spring Boot 3!";
        }

}
