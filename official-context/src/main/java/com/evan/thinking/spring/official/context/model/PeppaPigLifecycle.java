package com.evan.thinking.spring.official.context.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc: 小猪佩奇 声明周期延时类
 * @author: evan
 * @date: 2022-03-24
 */
@Data
@NoArgsConstructor
public class PeppaPigLifecycle
    implements BeanNameAware, ApplicationContextAware, ResourceLoaderAware, BeanClassLoaderAware {

    private String id;

    private String name;

    private Integer age;

    private String beanName;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    private ClassLoader classLoader;

    private ResourceLoader resourceLoader;

    public PeppaPigLifecycle(String name, Integer age, PeppaPigPq peppaPigPq) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        System.out.println(resourceLoader);
    }
}
