package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: Bean 元信息配置示例
 * @author: evan
 * @date: 2022/3/28
 */
public class BeanMetadataConfigurationDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        Resource resource = new ClassPathResource("META-INF/lifecycle-user.properties");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNum = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println(beanNum);

        System.out.println(beanFactory.getBean(User.class));
    }
}
