package com.evan.thinking.spring.geekbang.xmg.enviorment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @desc: 属性配置示例
 * @author: evan
 * @date: 2022/4/24
 */
public class ValueAnnoationDemo {

    @Value("${user.name}")
    private String userName;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ValueAnnoationDemo.class);
        context.refresh();

        ValueAnnoationDemo demo = context.getBean(ValueAnnoationDemo.class);
        System.out.println(demo.userName);
        context.close();

    }

}
