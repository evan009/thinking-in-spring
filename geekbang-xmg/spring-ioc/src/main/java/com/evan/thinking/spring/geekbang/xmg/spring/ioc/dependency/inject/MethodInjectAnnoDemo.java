package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserHolder;

/**
 * @desc: Setter 方法注入 注解
 * @author: evan
 * @date: 2022/3/26
 */
public class MethodInjectAnnoDemo {

    private UserHolder userHolder;
    private UserHolder userHolder2;

    @Autowired
    public void initUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    @Resource
    public void initUserHolder2(UserHolder userHolder) {
        this.userHolder2 = userHolder;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MethodInjectAnnoDemo.class);

        applicationContext.refresh();

        MethodInjectAnnoDemo demo = applicationContext.getBean(MethodInjectAnnoDemo.class);
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
