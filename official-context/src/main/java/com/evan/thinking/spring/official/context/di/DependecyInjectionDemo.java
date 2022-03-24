package com.evan.thinking.spring.official.context.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPig;

/**
 * @Desc: 依赖注入示例
 * @author: evan
 * @date: 2022-03-24
 */
public class DependecyInjectionDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-di.xml");
        context.refresh();

        // 构造函数注入
        System.out.println(context.getBean("pqFather", PeppaPig.class));
        // 属性注入
        System.out.println(context.getBean("pqMother", PeppaPig.class));


        context.close();

    }

}
