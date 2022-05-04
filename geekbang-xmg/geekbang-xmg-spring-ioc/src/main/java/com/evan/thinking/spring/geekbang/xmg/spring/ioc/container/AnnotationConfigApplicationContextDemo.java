package com.evan.thinking.spring.geekbang.xmg.spring.ioc.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.lookup.DependencyLookupDemo;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

@Configuration
public class AnnotationConfigApplicationContextDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationConfigApplicationContextDemo.class);
        applicationContext.refresh();
        DependencyLookupDemo.lookupByCollectionType(applicationContext);
        applicationContext.close();
        DependencyLookupDemo.lookupByCollectionType(applicationContext);

    }

    @Bean
    public User user() {
        User user = new User();
        user.setId("008");
        return user;
    }

}
