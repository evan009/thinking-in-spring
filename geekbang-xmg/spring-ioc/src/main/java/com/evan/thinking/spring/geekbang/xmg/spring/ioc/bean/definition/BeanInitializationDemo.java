package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class,
            com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition.ConfigUserBean.class);
        applicationContext.refresh();
        System.out.println("容器已启动...");

        System.out.println(applicationContext.getBean(ConfigUser.class));
        System.out.println("容器准备关闭...");
        applicationContext.close();
        System.out.println("容器已关闭...");

    }

}
