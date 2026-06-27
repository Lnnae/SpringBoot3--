package com.example.demo_redis.controller;

import com.example.demo_redis.entity.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 韩伟Q
 */
@RestController // 必须加，否则 @Autowired 无效且无法访问接口
public class RedisTest {

    @Autowired
    StringRedisTemplate redisTemplate1;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    //但是redis保存数据会使用默认的序列化机制，结果为乱码不可视
    //解决方法：应该使用json形式保存，自己建一个新的Bean来重写这个函数

    // 注入 Jackson 的工具类
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/ending")
    public String Rediss(){
        Long hello = redisTemplate1.opsForValue().increment("hello");
        return "访问了【"+ hello +"】次";
    }



    @GetMapping("/person/save")
    public String savePerson() throws JsonProcessingException {
        Person person = new Person();
        person.setName("奥奥");
        Person person2 = new Person(2L,"外",12);

        /*----第二种--手动--方法实践----*/
        // 【关键步骤】手动将对象转为 JSON 字符串
        // 这样存入 Redis 的就是纯粹的 JSON，没有任何多余的 @class 信息，极其省内存
        /*
        * 为什么这样做“手动”更好？
            1、空间极省：自动转换（GenericJackson...）会在 Redis 里存入类似 {"@class":"com.example.Person", "name":"张三"}。
            *           手动转只存 {"name":"张三"}。如果数据量大，能省下几百 MB 甚至几个 GB 的 Redis 内存。
            兼容性好：以后如果你把 Java 的类名改了，或者换成 Python/Go 来读这个 Redis，手动存的纯 JSON 都能读，而带 @class 的只有原来的 Java 项目能读。
            可控性：你可以控制只序列化哪些字段。
        * */
        String jsonPerson = objectMapper.writeValueAsString(person);
        String jsonPerson2 = objectMapper.writeValueAsString(person2);

        // 现在传进去的是 String，符合你配置的 String 序列化器
        redisTemplate.opsForValue().set("person", jsonPerson);
        redisTemplate.opsForValue().set("person2", jsonPerson2);


        /*----第一种方法实践----*/
        //方法1、此处需要一个序列化来保存字符串
        //方法2、可以使用RedisTemplate来获取，因为它的set函数是Object型

        /*  --自定义定制序列化--
            但是在redis中的数据是不可视，乱码。
            我们需要转为json格式。在AppRedisConfig.java编写
        */

        //redisTemplate.opsForValue().set("B",person2);

        return "ok";
    }


    @GetMapping("/person/get")
    public Person getPerson() throws JsonProcessingException{
        String person = (String) redisTemplate.opsForValue().get("person2");
        // 2. 手动转回对象
        if (person != null) {
            return objectMapper.readValue(person, Person.class);
        }
        return null;
    }
}
