package com.evan.thinking.spring.geekbang.xmg.questions;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: 循环依赖
 * @author: evan
 * @date: 2022/5/2
 */
public class BeanCircularDemo {

    /**
     * <p>
     *     1：单例属性
     *      DefaultSingletonBeanRegistry#singletonFactories
     *     2：早期未处理方法
     *      AbstractAutowireCapableBeanFactory#getEarlyBeanReference()
     *     3：早期未处理属性
     *      DefaultSingletonBeanRegistry#earlySingletonObjects
     * </p>
     * @param args
     */
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanCircularDemo.class);

        context.refresh();

        // 单例
        BeanCircularDemo beanCacheDemo = context.getBean(BeanCircularDemo.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(beanCacheDemo == context.getBean(BeanCircularDemo.class));
        }

        // 原型
        User user = context.getBean(User.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(user == context.getBean(User.class));
        }
        context.close();

    }





}
