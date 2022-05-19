package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.source;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

/**
 * @desc: 依赖来源示例
 * @author: evan
 * @date: 2022/3/27
 */
public class DependencySourceDemo {

    // 注入在 postProcessProperties 方法执行，早于 setter注入，也早于 @PostConstruct
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        System.out.println(beanFactory == applicationContext);
        System.out.println(beanFactory == applicationContext.getAutowireCapableBeanFactory());
        System.out.println(resourceLoader == applicationContext);
        System.out.println(applicationEventPublisher == applicationContext);
    }

    @PostConstruct
    public void initByLookup() {
        getBean(BeanFactory.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationContext.class);
        getBean(ApplicationEventPublisher.class);
        getBean(Environment.class);
    }

    private <T> T getBean(Class<T> beanType) {
        try {
            return beanFactory.getBean(beanType);
        } catch (NoSuchBeanDefinitionException e) {
            System.err.println("当前类型" + beanType.getName() + " 无法在 BeanFactory 中查找!");
        }
        return null;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencySourceDemo.class);

        applicationContext.refresh();
        System.out.println(applicationContext.getBean(DependencySourceDemo.class));

        applicationContext.close();

    }

}
