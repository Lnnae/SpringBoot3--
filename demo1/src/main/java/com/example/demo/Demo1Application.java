package com.example.demo;

import com.example.demo.bean.*;
import com.example.demo.demos.web.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //标注的类就是主程序类。
public class Demo1Application {

    public static void main(String[] args) {

       var ioc = SpringApplication.run(Demo1Application.class, args);
        // 1、获取容器中所有组件的名字
        //String[] beanNames = ioc.getBeanDefinitionNames();

//        for (String beanName : beanNames) {
//            System.out.println("beanName = " + beanName);
//        }

//        String[] ForType = ioc.getBeanNamesForType(MyUsers.class);
//        for (String s : ForType) {
//            System.out.println(s);
//        }
        MyUsers bean = ioc.getBean(MyUsers.class);
        System.out.println("user"+bean);
//
//        Object user_my1 = ioc.getBean("I bean");
//        Object user_my2 = ioc.getBean("I bean");
//        System.out.println(user_my1 == user_my2);//单例是true

        /*   条件注解   */
        //getBeanNamesForType获取指定类型的所有 Bean 的名称
//        for (String s : ioc.getBeanNamesForType(Cat.class)) {
//            System.out.println("Cat:" + s);
//        }
//
//        for (String s : ioc.getBeanNamesForType(Dog.class)) {
//            System.out.println("Dog:" + s);
//        }
//
//        for (Object s : ioc.getBeanNamesForType(Cat.class)) {
//            System.out.println("my::"+s);
//        }

        //根据 Bean 的名称获取 Bean 实例
        //如果定义了多个Bean，可以对第一个形参输入创建的bean的名称进行筛选
        //方案二：使用 @Primary 指定主选（一劳永逸）
        Cat bean1 = (Cat) ioc.getBean("MY CAT!",Cat.class);
        System.out.println(bean1);

//        Pig bean = ioc.getBean(Pig.class);
//        System.out.println(bean);
//
//        sheep bean1 = ioc.getBean(sheep.class);
//        System.out.println(bean1);

        //获取所有组件的名字
//        for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {
//            System.out.println("all tool:"+ beanDefinitionName);
//        }

        Person bean2 = ioc.getBean(Person.class);
        System.out.println("person " + bean2);
        System.out.println("===================");

        String s = bean2.getChild().getText().get(2);
        System.out.println(s);
        System.out.println("===================");
        String s1 = bean2.getChild().getText().get(3);
        System.out.println(s1);
    }

}
