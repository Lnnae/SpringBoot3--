package com.example.demo_rpc.Service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URL;

public interface SmsInterface {

    @GetExchange(url = "https://kzexpress.market.alicloudapi.com/api-mall/api/express/query", accept ="application/json" )
    Mono<String> getExpress(@RequestParam("expressNo") String number);



}
