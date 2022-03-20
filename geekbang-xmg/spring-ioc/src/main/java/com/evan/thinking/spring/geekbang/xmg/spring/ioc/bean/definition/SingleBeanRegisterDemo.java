package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition.factory.DefaultUserFactory;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition.factory.UserFactory;

/**
 * @desc: 单体Bean注册实例
 * @author: evan
 * @date: 2022/3/20
 */
public class SingleBeanRegisterDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 单体Bean实例对象
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("userFactory", userFactory);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("userFactory"));
        // 关闭 Spring 应用上下文
        applicationContext.close();
    }

}
