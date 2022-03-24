package com.evan.thinking.spring.official.context.bean.instanting;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPig;

/**
 * @Desc: Bean 实例化
 * @author: evan
 * @date: 2022-03-24
 */
public class BeanInstantingDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-context.xml");
        context.refresh();
        // 构造器实例化
        System.out.println(context.getBean("pq", PeppaPig.class));
        // 静态方法实例化
        System.out.println(context.getBean("qz", PeppaPig.class));
        // 实例工厂方法实例化
        System.out.println(context.getBean("sx", PeppaPig.class));
        // 实例工厂方法实例化
        System.out.println(context.getBean("pdl", PeppaPig.class));

        // 获取所有实例对象
        System.out.println(context.getBeansOfType(PeppaPig.class));
        context.close();
    }

}
