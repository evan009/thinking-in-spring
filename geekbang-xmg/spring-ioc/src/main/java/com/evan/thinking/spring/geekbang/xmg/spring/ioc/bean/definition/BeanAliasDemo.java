package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

public class BeanAliasDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-alias.xml");
        User pq = beanFactory.getBean("pq", User.class);
        User user1 = beanFactory.getBean("user1", User.class);

        System.out.println(pq == user1);

    }

}
