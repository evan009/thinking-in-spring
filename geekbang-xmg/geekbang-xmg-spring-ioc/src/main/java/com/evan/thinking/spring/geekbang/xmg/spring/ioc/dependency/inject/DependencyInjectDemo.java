package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserRepository;

public class DependencyInjectDemo {

    public static void main(String[] args) {

        //
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/dependency-injection.xml");
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository);
        System.out.println(applicationContext);
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory().getBean("superUser"));
        System.out.println(userRepository.getObjectFactoryUser().getObject());
        System.out.println(applicationContext == userRepository.getBeanFactory());
        System.out.println(applicationContext == userRepository.getObjectFactoryContext().getObject());
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
//        System.out.println(applicationContext.getBean(ApplicationContext.class));

    }

}
