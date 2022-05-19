package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition.factory.DefaultUserFactory;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition.factory.UserFactory;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.SuperUser;

/**
 * @desc: Bean实例化
 * @author: evan
 * @date: 2022/3/20
 */
public class BeanInstantiationSpeicalDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("META-INF/bean-instantiation-speical.xml");
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        // demoServiceLoader();
        // 通过serviceLoader
        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        displayServiceLoader(serviceLoader);
        // 方法二
        DefaultUserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
        SuperUser superUser = beanFactory.createBean(SuperUser.class);
        System.out.println(superUser);
    }

    private static void demoServiceLoader() {
        ServiceLoader<UserFactory> userFactories =
            ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(userFactories);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }

}
