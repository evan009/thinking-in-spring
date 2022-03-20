package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @desc: Bean垃圾回收
 * @author: evan
 * @date: 2022/3/20
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.Config.class);
        applicationContext.refresh();
        System.out.println("容器已启动...");

        System.out.println(applicationContext.getBean(BeanInitializationDemo.ConfigUser.class));
        System.out.println("容器准备关闭...");
        applicationContext.close();
        System.out.println("容器已关闭...");
        Thread.sleep(5000);
        System.gc();
        Thread.sleep(5000);
    }

}
