package com.example.demo_rpc.Service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface WeatherInterface {

    @PostExchange(value="https://jmweather.market.alicloudapi.com/weather/query/15d", contentType = "application/x-www-form-urlencoded")
    Mono<String> gerWeather(@RequestParam("area") String city);
    //auto负责获取APPCODE
}
