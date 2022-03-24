package com.evan.thinking.spring.official.context.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: 本存在依赖关系
 * @author: evan 
 * @date: 2022-03-24
 */ 
public class DependsOnDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-di.xml");
        context.refresh();

        context.close();

    }

}
