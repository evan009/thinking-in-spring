package com.evan.thinking.spring.geekbang.xmg.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @desc: Spring ApplicationListener 事件
 * @author: evan
 * @date: 2022/4/17
 */
@EnableAsync
public class ApplicationListenerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationListenerDemo.class);

        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("接受到的事件" + event);
            }
        });
        applicationContext.registerShutdownHook();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "JVM 容器关闭触发钩子事件");
            }
        });
        applicationContext.refresh();
        // applicationContext.start();
        // applicationContext.stop();

    }

    @EventListener
    @Async
    public void refreshedEvent(ContextRefreshedEvent event) {
        System.out.println(Thread.currentThread().getName() + "  @EventListener 接受到的事件" + event);
    }

    @EventListener
    public void closedEvent(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().getName() + "  @EventListener 接受到的事件" + event);
    }

    // @EventListener
    // public void contextEvent(ApplicationContextEvent event) {
    // System.out.println(" @EventListener 接受到的事件" + event);
    // }

}
