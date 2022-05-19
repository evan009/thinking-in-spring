package com.evan.thinking.spring.geekbang.xmg.spring.ioc.container;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class GenericApplicationContextDemo {

    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("META-INF/dependency-lookup.xml");
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("user1"));
        applicationContext.close();
    }

}
