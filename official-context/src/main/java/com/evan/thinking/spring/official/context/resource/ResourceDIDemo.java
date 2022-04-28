package com.evan.thinking.spring.official.context.resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.official.context.model.SuperPeppaPig;

/**
 * @Desc: 资源依赖注入
 * @author: evan
 * @date: 2022-04-07
 */
public class ResourceDIDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/bean-inheritance.xml");
        applicationContext.refresh();

        // 通过字段注入资源信息
        System.out.println(applicationContext.getBean(SuperPeppaPig.class));

        applicationContext.close();
    }

}
