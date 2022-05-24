package com.evan.thinking.spring.official.context.bean.annotation;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @desc: Autowired 注解示例
 * @author: evan
 * @date: 2022/5/18
 */
public class AutowiredContextDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AutowiredPeppaPig.class);
        // 装配XML文件Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(context);
        beanDefinitionReader.loadBeanDefinitions("META-INF/bean-context.xml");

        context.refresh();

        AutowiredPeppaPig autowiredPeppaPig = context.getBean(AutowiredPeppaPig.class);
        System.out.println(autowiredPeppaPig);
        System.out.println(autowiredPeppaPig.peppaPigArr);
        System.out.println(autowiredPeppaPig.peppaPigMap);
        System.out.println(autowiredPeppaPig.allObject);

        context.close();

    }

}
