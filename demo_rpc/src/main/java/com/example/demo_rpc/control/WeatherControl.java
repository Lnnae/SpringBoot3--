package com.example.demo_rpc.control;

import com.example.demo_rpc.Service.SmsInterface;
import com.example.demo_rpc.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tools.jackson.databind.ObjectMapper;

/**
 * @author 韩伟Q
 */
@RestController
public class WeatherControl {

    @Autowired
    WeatherService weatherService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SmsInterface smsInterface;

    @GetMapping("/weather/15d")
    // 返回类型改为 Mono<String>Mono非阻塞代码
    public Mono<Object> weather(@RequestParam("area") String area) {
        return weatherService.weather(area)
                .map(jsonString -> {
                    try {
                        // 把硬邦邦的字符串转成 JSON 对象（Map）
                        return objectMapper.readValue(jsonString, Object.class);
                    } catch (Exception e) {
                        return jsonString;
                    }
                });
    }

    //查物流
    @GetMapping("/expressNo")
    public Mono<String> SMS(@RequestParam("number") String number){
        return smsInterface.getExpress(number);
    }
}