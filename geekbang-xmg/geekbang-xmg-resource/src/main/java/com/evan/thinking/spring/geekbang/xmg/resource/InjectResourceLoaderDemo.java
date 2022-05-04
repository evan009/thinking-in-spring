package com.evan.thinking.spring.geekbang.xmg.resource;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

/**
 * @desc: 注入Resource示例
 * @author: evan
 * @date: 2022/4/9
 */
public class InjectResourceLoaderDemo implements ResourceLoaderAware {

    private ResourceLoader resourceAware;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private AbstractApplicationContext applicationContext;

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectResourceLoaderDemo.class);
        applicationContext.refresh();
        applicationContext.close();

    }


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceAware = resourceLoader;
    }

    @PostConstruct
    public void init(){
        System.out.println(resourceAware == resourceLoader);
        System.out.println(resourceAware == applicationContext);

    }
}
