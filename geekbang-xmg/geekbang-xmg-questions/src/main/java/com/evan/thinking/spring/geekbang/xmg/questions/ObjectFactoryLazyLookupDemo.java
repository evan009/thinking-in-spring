package com.evan.thinking.spring.geekbang.xmg.questions;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: 依赖延迟查找
 * @author: evan
 * @date: 2022/5/2
 */
public class ObjectFactoryLazyLookupDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ObjectFactoryLazyLookupDemo.class);

        context.refresh();

        ObjectFactoryLazyLookupDemo lazyLookupDemo = context.getBean(ObjectFactoryLazyLookupDemo.class);

        ObjectProvider<User> userObjectProvider = lazyLookupDemo.userObjectProvider;
        ObjectFactory<User> userObjectFactory = lazyLookupDemo.userObjectFactory;

        System.out.println(userObjectFactory == userObjectProvider);
        System.out.println(userObjectFactory.getClass() == userObjectProvider.getClass());


        System.out.println(userObjectFactory.getObject());
        System.out.println(userObjectProvider.getObject());
        System.out.println(context.getBean(User.class));

        context.close();

    }

    @Autowired
    private ObjectFactory<User> userObjectFactory;
    @Autowired
    private ObjectProvider<User> userObjectProvider;

    @Bean
    @Lazy
    public User user() {
        User user = new User();
        user.setId("220502");
        user.setName("延迟查找");
        System.out.println("创建user对象");
        return user;
    }

}
