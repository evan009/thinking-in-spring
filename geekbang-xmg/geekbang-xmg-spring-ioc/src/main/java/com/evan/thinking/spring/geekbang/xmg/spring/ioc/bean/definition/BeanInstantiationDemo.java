package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: Bean实例化
 * @author: evan 
 * @date: 2022/3/20
 */ 
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-instantiation.xml");
        User userByStaticMethod = beanFactory.getBean("user-by-static-method",User.class);
        System.out.println(userByStaticMethod);
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method",User.class);
        System.out.println(userByInstanceMethod);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean",User.class);
        System.out.println(userByFactoryBean);

        System.out.println(userByStaticMethod==userByInstanceMethod);
        System.out.println(userByStaticMethod==userByFactoryBean);
    }

}
