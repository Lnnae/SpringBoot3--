package com.example.demo_redis.Config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author 韩伟Q
 */

@Configuration
public class AppRedisConfig {
    /*
    * redisConnectionFactory:连接工厂
    */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        /*----第一种方法----*/
        /*----但是很容易费内存，它需要把参数都填上----*/

        //将对象转为json形式的序列化格式
        //template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());

        /*   ----第二种方法----   */
        /*----但是不容易费内存，它不需要把参数都填上，只需要填自己想要的----*/
        // key 采用 String 序列化
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());

        // value 也采用 String 序列化（这就要求你传给 template 的值必须手动转成 String）
        template.setValueSerializer(RedisSerializer.string());
        template.setHashValueSerializer(RedisSerializer.string());

        return template;
    }
}
