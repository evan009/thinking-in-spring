package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @desc: Bean 元信息 解析
 * @author: evan
 * @date: 2022/3/28
 */
public class AnnotatedBeanDefinitionParsingDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beanDefinitionCountBefore = beanFactory.getBeanDefinitionCount();
        beanDefinitionReader.register(AnnotatedBeanDefinitionParsingDemo.class);
        int beanDefinitionCountAfter = beanFactory.getBeanDefinitionCount();
        int beanDefinitionCount = beanDefinitionCountAfter - beanDefinitionCountBefore;
        System.out.println("已加载 BeanDefinition 数量：" + beanDefinitionCount);
        // bean 名称 org.springframework.context.annotation.AnnotationBeanNameGenerator
        AnnotatedBeanDefinitionParsingDemo demo =
            beanFactory.getBean("annotatedBeanDefinitionParsingDemo", AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(demo);
    }
}
