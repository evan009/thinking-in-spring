package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @desc: Aware 接口回调
 * @author: evan
 * @date: 2022/3/26
 */
public class AwareInterfaceInjectAnnoDemo implements BeanNameAware, ApplicationContextAware {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AwareInterfaceInjectAnnoDemo.class);

        applicationContext.refresh();

        System.out.println(AwareInterfaceInjectAnnoDemo.applicationContext);
        System.out.println(AwareInterfaceInjectAnnoDemo.beanName);

        applicationContext.close();

    }

    private static String beanName;
    private static ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        AwareInterfaceInjectAnnoDemo.beanName = beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareInterfaceInjectAnnoDemo.applicationContext = applicationContext;
    }
}
