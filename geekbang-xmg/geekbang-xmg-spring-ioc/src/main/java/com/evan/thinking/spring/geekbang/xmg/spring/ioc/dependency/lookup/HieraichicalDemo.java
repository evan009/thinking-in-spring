package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: {@link org.springframework.beans.factory.HierarchicalBeanFactory}
 * @author: evan
 * @date: 2022/3/24
 */
public class HieraichicalDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("META-INF/dependency-lookup.xml");
        // 获取层次性BeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println(beanFactory.getParentBeanFactory());
        HierarchicalBeanFactory parentFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentFactory);
        System.out.println(beanFactory.getParentBeanFactory());

        System.out.println(beanFactory.getBean("user-by-static-method"));
        System.out.println(parentFactory.getBean("user-by-static-method"));
        System.out.println(beanFactory.containsBean("user-by-static-method"));
        System.out.println(parentFactory.containsBean("user-by-static-method"));
        applicationContext.refresh();

        applicationContext.close();
    }

    public static HierarchicalBeanFactory createParentBeanFactory() {
        HierarchicalBeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-instantiation.xml");
        return beanFactory;
    }

}
