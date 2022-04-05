package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserLifeCycle;

/**
 * @desc: Bean 初始化
 * @author: evan
 * @date: 2022/3/31
 */
public class BeanInitiailizationLifecycleDemo {

    public static void main(String[] args) throws InterruptedException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new CustomInstantiationAwareBeanPostProcessor());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("META-INF/bean-initialization.xml");

        // 添加 BeanPostProcessor
        beanFactory.addBeanPostProcessor(new UserLifecycleBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
        beanFactory.preInstantiateSingletons();
        UserLifeCycle userLifeCycle = beanFactory.getBean(UserLifeCycle.class);
        System.out.println(userLifeCycle);
        System.out.println("开始销毁");
        beanFactory.destroyBean("UserLifeCycle",userLifeCycle);
        System.out.println(userLifeCycle);
        beanFactory.destroySingletons();
        System.out.println("bean gc");
        userLifeCycle = null;
        System.gc();
//        Thread.sleep(2000);
//        System.gc();
//        System.out.println(userLifeCycle);

    }



}
