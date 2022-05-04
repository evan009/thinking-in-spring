package com.evan.thinking.spring.geekbang.xmg.context.lifecycle;

import java.io.IOException;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShutdownHookDemo {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ShutdownHookDemo.class);
//        context.registerShutdownHook();
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.printf("%s线程关闭 %s \n", Thread.currentThread().getName(), event.getClass().getSimpleName());
            }
        });
        context.refresh();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("接受到关闭信号量");
                context.close();
            }
        });
        System.out.println("按任意键继续...");
    }

}
