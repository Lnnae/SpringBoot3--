package com.example.demo_logging.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 韩伟Q
 */
@Slf4j
@RestController
public class Mycontroler {

    @GetMapping("/he")
    public String hello(){
        log.info("哈哈哈哈成功");
        log.warn("warn 日志" );
        log.debug("debug 日志");
        return "hello";
    }
}
