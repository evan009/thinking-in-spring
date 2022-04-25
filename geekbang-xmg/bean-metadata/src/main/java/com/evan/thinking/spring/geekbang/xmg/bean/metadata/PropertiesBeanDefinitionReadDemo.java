package com.evan.thinking.spring.geekbang.xmg.bean.metadata;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: Bean 配置元信息 示例
 * @author: evan
 * @date: 2022/4/5
 */
public class PropertiesBeanDefinitionReadDemo {

    public static void main(String[] args) {

        // 传建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 创建PropertiesBeanDefinitionReader
        PropertiesBeanDefinitionReader definitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        Resource resource = new ClassPathResource("META-INF/user-properties.properties");
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNum = definitionReader.loadBeanDefinitions(encodedResource);
        System.out.println(beanNum);
        System.out.println(beanFactory.getBean(User.class));
    }

}
