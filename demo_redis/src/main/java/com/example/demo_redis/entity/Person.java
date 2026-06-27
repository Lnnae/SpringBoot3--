package com.example.demo_redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 韩伟Q
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person  implements Serializable {
    //implements Serializable
    //err报错:JdkSerializationRedisSerializer，需要序列化
    //解决方法：设置继承Serializable的接口即可
    private long id;
    private String name;
    private  Integer age;
    //private Date day;
}
