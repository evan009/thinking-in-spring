package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserHolder;

public class AutowireDemo {

    public static void main(String[] args) {
        //
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("META-INF/dependency-injection.xml");

        applicationContext.refresh();

        System.out.println(applicationContext.getBean("userHolderAutowireByName", UserHolder.class));
        System.out.println(applicationContext.getBean("userHolderAutowireByType", UserHolder.class));
        System.out.println(applicationContext.getBean("userHolderAutowireByConstructor", UserHolder.class));

        applicationContext.close();
    }

}
