package com.example.demo_rpc.config;

import com.example.demo_rpc.Service.SmsInterface;
import com.example.demo_rpc.Service.WeatherInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author 韩伟Q
 */
@Configuration
public class WeatherConfig {

    /*创造一个工厂，以后只要有api调用调用这个方法直接创建*/
    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory(){
        //创建客户端
        WebClient client = WebClient.builder()
                .defaultHeader("Authorization", "APPCODE " + "24b6616ce77a432f851271d3135c305d")
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer
                            .defaultCodecs()
                            .maxInMemorySize(256*1024*1024);
                })
                .build();
        //得到工厂
        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(adapter).build();
        return factory;
    }


    @Bean
    WeatherInterface weatherInterface(HttpServiceProxyFactory httpServiceProxyFactory){

        WeatherInterface weatherAPI = httpServiceProxyFactory.createClient(WeatherInterface.class);
        return weatherAPI;
    }

    @Bean
    SmsInterface smsInterface(){
        SmsInterface client = httpServiceProxyFactory().createClient(SmsInterface.class);
        return client;

    }

}
