package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: Bean 元信息配置示例
 * @author: evan
 * @date: 2022/3/28
 */
public class MergedBeanDefinitionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        int beanNum = beanDefinitionReader.loadBeanDefinitions("META-INF/dependency-lookup.xml");
        System.out.println(beanNum);

        System.out.println(beanFactory.getBean("user1", User.class));
        System.out.println(beanFactory.getBean("superUser", User.class));

    }
}
