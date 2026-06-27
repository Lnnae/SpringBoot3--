package com.example.demo.config;

//import com.alibaba.druid.FastsqlException;
import com.alibaba.druid.FastsqlException;
import com.example.demo.bean.Cat;
import com.example.demo.bean.Dog;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author 韩伟Q
 */
@EnableConfigurationProperties(FastsqlException.class)
@SpringBootConfiguration    //这是配置类
public class appconfig2 {
    @ConditionalOnClass(name="com.alibaba.druid.FastsqlException")
    @Bean("this CAT!")
    public Cat cat(){
        Cat cat = new Cat();
        return cat;
    }
    @Bean("MY CAT!")
    public Cat cat2(){
        Cat cat2 = new Cat();
        return cat2;
    }

    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog(){
        return new Dog();
    }
}
