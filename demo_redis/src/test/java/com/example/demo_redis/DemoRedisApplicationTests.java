package com.example.demo_redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@SpringBootTest
class DemoRedisApplicationTests {

    @Autowired
    StringRedisTemplate redisTemplate;
    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("haha", UUID.randomUUID().toString());

        String haha = redisTemplate.opsForValue().get("haha");//我得到我创建的值
        String hello = redisTemplate.opsForValue().get("hello");//获取在redis软件中的数据
        System.out.println(haha);
        System.out.println(hello);
    }
    @Test
    void TestList() {
        String name = "one";
        redisTemplate.opsForList().leftPush(name,"1");
        redisTemplate.opsForList().leftPush(name,"2");
        redisTemplate.opsForList().leftPush(name,"3");

        String s = redisTemplate.opsForList().leftPop(name);
        Assertions.assertEquals("3",s);

    }
}
