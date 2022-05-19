package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserHolder;

/**
 * @desc: 基于Java注解的方法注入
 * @author: evan
 * @date: 2022/3/26
 */
public class FilledInjectAnnoDemo {

    /**
     * Autowired 注解会忽略掉静态字段和静态方法 byType
     */
    @Autowired
    private UserHolder userHolder;
    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(FilledInjectAnnoDemo.class);

        applicationContext.refresh();

        FilledInjectAnnoDemo demo = applicationContext.getBean(FilledInjectAnnoDemo.class);
        System.out.println(demo.userHolder);
        System.out.println(demo.userHolder2);

        System.out.println(demo.userHolder == demo.userHolder2);

        applicationContext.close();

    }

    @Bean
    public UserHolder userHolder(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    @Bean
    public User user() {
        return User.createUser();
    }

}
