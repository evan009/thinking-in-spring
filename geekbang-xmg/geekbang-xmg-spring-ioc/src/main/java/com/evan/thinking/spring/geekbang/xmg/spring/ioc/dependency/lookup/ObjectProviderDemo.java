package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: {@link org.springframework.beans.factory.ObjectProvider}
 * @author: evan 
 * @date: 2022/3/24
 */ 
public class ObjectProviderDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/dependency-lookup.xml");
        applicationContext.refresh();
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);
        System.out.println(objectProvider.getObject());
        applicationContext.close();
    }

}
