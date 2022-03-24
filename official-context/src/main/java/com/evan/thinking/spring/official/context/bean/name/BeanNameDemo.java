package com.evan.thinking.spring.official.context.bean.name;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPig;

/**
 * @Desc: Bean 命名和容器使用
 * @author: evan
 * @date: 2022-03-24
 */
public class BeanNameDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-context.xml");

        context.refresh();

        System.out.println(context.getBean(PeppaPig.class));
        System.out.println(context.getBean("peppaPig", PeppaPig.class));

        context.close();

    }

}
