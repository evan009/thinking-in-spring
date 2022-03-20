package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.SuperAnno;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

public class DependencyLookupDemo {

    public static void main(String[] args) {

        //
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup.xml");

        lookupByType(beanFactory);
        lookupByCollectionType(beanFactory);

        // 通过注解查找对象
        lookupByAnnotationType(beanFactory);

        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            System.out.println(listableBeanFactory.getBeansWithAnnotation(SuperAnno.class));
        }
    }

    public static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            System.out.println(listableBeanFactory.getBeansOfType(User.class));
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找：" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user", User.class);
        System.out.println("实时查找：" + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }
}
