package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.source;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @desc: 游离对象注册
 * @author: evan
 * @date: 2022/3/27
 */
public class ResolvableDependencySourceDemo {

    @Autowired
    private String str;

    @PostConstruct
    public void init() {
        System.out.println(str);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerResolvableDependency(String.class, "ResolvableDependency");
        });
        applicationContext.refresh();

        System.out.println(applicationContext.getBean(ResolvableDependencySourceDemo.class));

        applicationContext.close();

    }

}
