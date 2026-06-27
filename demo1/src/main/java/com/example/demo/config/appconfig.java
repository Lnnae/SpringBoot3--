package com.example.demo.config;

//import com.alibaba.druid.FastsqlException;
//import com.alibaba.druid.FastsqlException;
import com.alibaba.druid.FastsqlException;
import com.example.demo.bean.MyUsers;
import com.example.demo.bean.Pig;
import com.example.demo.bean.sheep;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @author 韩伟Q
 */
@Import(FastsqlException.class)
@SpringBootConfiguration
/*
*   开启sheep属性绑定
* */
@EnableConfigurationProperties(sheep.class)

//@Configuration//这是配置类
public class appconfig {

    @Bean
    @ConfigurationProperties(prefix = "pig")
    public Pig pig(){
        return new Pig();
    }
    /*
            组件默认是单实例
     */

    //@Scope("prototype") //设置成多实例
    @Bean("I bean")
    //组件在容器中的名字默认是方法名，可以直接修改注解的值
        public MyUsers user(){
            var user = new MyUsers();
            user.setId(12L);
            user.setName("toms");
            return user;
        }
}
