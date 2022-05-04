package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserHolder;

/**
 * @desc: Setter 方法注入 注解
 * @author: evan
 * @date: 2022/3/26
 */
public class SetterInjectAnnoDemo {

    public static void main(String[] args) {

        //
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SetterInjectAnnoDemo.class);

        applicationContext.refresh();
        System.out.println(applicationContext.getBean("userHolder", UserHolder.class));

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
