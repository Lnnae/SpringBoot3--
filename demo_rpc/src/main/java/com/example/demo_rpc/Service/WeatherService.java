package com.example.demo_rpc.Service;

import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 韩伟Q
 */
@Service
public class WeatherService {

    /*----Webclient方法实现----*/
    WebClient webClient = WebClient.create();

    @Autowired
    WeatherInterface weatherInterface;

    public Mono<String> weather(String area) {
        Map<String, String> params = new HashMap<>();
        params.put("area", area);

        //Mono<String> post = getWebClient(area, params);


        Mono<String> weather = weatherInterface.gerWeather(area);


        // 注意：这里删掉了 .block()
        return weather;
    }

    private Mono<String> getWebClient(String area, Map<String, String> params) {
        Mono<String> post = webClient.post()
                .uri("https://jmweather.market.alicloudapi.com/weather/query/15d?area={area}", params)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("area", area))
                .retrieve()
                .bodyToMono(String.class);
        return post;
    }
}