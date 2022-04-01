package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import java.util.Collection;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject.anno.UserGroup;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: 延迟注入
 * @author: evan
 * @date: 2022/3/26
 */
public class LazyInjectDemo {

    @Autowired
    private User user;
    @Autowired
    private ObjectProvider<User> objectProviderUser;
    @Autowired
    private ObjectProvider<Collection<User>> objectProviderUsers;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LazyInjectDemo.class);
        // 装配XML文件Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("META-INF/dependency-injection.xml");

        applicationContext.refresh();
        LazyInjectDemo lazyInjectDemo = applicationContext.getBean(LazyInjectDemo.class);
        System.out.println(lazyInjectDemo.user);
        System.out.println(lazyInjectDemo.objectProviderUser);
        System.out.println(lazyInjectDemo.objectProviderUser.getObject());
        System.out.println(lazyInjectDemo.objectProviderUsers.getObject());

        applicationContext.close();
    }

}
