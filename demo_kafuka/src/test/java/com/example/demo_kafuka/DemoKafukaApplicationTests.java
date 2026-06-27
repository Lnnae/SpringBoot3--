package com.example.demo_kafuka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
class DemoKafukaApplicationTests {

    @Autowired
    KafkaTemplate kafkaTemplate;


    @Test
    void contextLoads() {
        StopWatch stopWatch = new StopWatch();
        CompletableFuture[] futures = new CompletableFuture[1000];
        stopWatch.start();
        for (int i = 0; i < 1000; i++) {
            CompletableFuture send = kafkaTemplate.send("pick", "jjjj", "ggg");
            futures[i]=send;
        }
        stopWatch.stop();
        CompletableFuture.allOf(futures).join();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();

        System.out.println("完成传输 时间：" + totalTimeMillis);
    }

}
