package com.example.demo_security.LoginControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 韩伟Q
 */
@Controller
public class login {

    @GetMapping("/login")
    public String login(){

        return "login";
    }


}
