package com.evan.thinking.spring.official.context.bean.extension;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: BeanPostProcessor 示例
 * @author: evan 
 * @date: 2022/5/9
 */ 
public class BeanPostProcessorDemo {


    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "META-INF/bean-context.xml";
        reader.loadBeanDefinitions(location);
        beanFactory.addBeanPostProcessor(new PeppaPigBeanPostProcessor());
        System.out.println(beanFactory.getBean("peppaPig"));

    }

}
