package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserHolder;

/**
 * @desc: Setter 方法注入 API
 * @author: evan
 * @date: 2022/3/26
 */
public class ConstructorInjectApiDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        // 注册 UserHolder 的 BeanDefinition
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        // 装配XML文件Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("META-INF/dependency-injection.xml");

        applicationContext.refresh();
        System.out.println(applicationContext.getBean("userHolder", UserHolder.class));
        applicationContext.close();

    }

    private static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        definitionBuilder.addConstructorArgReference("superUser");
        return definitionBuilder.getBeanDefinition();
    }

}
