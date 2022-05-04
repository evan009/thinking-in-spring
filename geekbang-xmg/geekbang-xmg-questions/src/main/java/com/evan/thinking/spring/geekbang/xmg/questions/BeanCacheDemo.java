package com.evan.thinking.spring.geekbang.xmg.questions;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: Bean 对象是否缓存
 * @author: evan
 * @date: 2022/5/2
 */
public class BeanCacheDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanCacheDemo.class);

        context.refresh();

        // 单例
        BeanCacheDemo beanCacheDemo = context.getBean(BeanCacheDemo.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(beanCacheDemo == context.getBean(BeanCacheDemo.class));
        }

        // 原型
        User user = context.getBean(User.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(user == context.getBean(User.class));
        }
        context.close();

    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User user() {
        User user = new User();
        user.setId("220502");
        user.setName("延迟查找");
        System.out.println("创建user对象");
        return user;
    }

}
