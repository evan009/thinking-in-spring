package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject.anno.UserGroup;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: Qualifer
 * @author: evan
 * @date: 2022/3/26
 */
public class QualiferInjectDemo {

    @Autowired
    private User user;
    @Autowired
    @Qualifier("user2")
    private User namedUser;

    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifierUsers;

    @Autowired
    @UserGroup
    private Collection<User> qualifierUserGroups;



    @Bean
    @Qualifier
    public User userQualifier1(){
        User user = new User();
        user.setName("userQualifier1");
        return user;
    }

    @Bean
    @Qualifier
    public User userQualifier2(){
        User user = new User();
        user.setName("userQualifier2");
        return user;
    }


    @Bean
    @UserGroup
    public User userGroupQualifier1(){
        User user = new User();
        user.setName("userGroupQualifier1");
        return user;
    }

    @Bean
    @UserGroup
    public User userGroupQualifier2(){
        User user = new User();
        user.setName("userGroupQualifier2");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualiferInjectDemo.class);
        // 装配XML文件Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("META-INF/dependency-injection.xml");

        applicationContext.refresh();

        QualiferInjectDemo injectDemo = applicationContext.getBean(QualiferInjectDemo.class);
        System.out.println(injectDemo.user);
        System.out.println(injectDemo.namedUser);
        System.out.println(injectDemo.allUsers);
        System.out.println(injectDemo.qualifierUsers);
        System.out.println(injectDemo.qualifierUserGroups);

        applicationContext.close();
    }

}
