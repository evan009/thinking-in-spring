package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserHolder;

/**
 * @desc: Setter 方法注入 XML文件
 * @author: evan
 * @date: 2022/3/26
 */
public class SetterInjectXMLDemo {

    public static void main(String[] args) {

        //
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("META-INF/dependency-injection.xml");

        applicationContext.refresh();

        System.out.println(applicationContext.getBean("userHolder", UserHolder.class));

        applicationContext.close();

    }

}
