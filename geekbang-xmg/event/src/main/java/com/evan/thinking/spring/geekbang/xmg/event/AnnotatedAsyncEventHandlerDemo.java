package com.evan.thinking.spring.geekbang.xmg.event;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

import java.util.concurrent.ExecutorService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

/**
 * @desc: 事件异步注解实现
 * @author: evan
 * @date: 2022/4/17
 */
@EnableAsync
public class AnnotatedAsyncEventHandlerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotatedAsyncEventHandlerDemo.class);
        applicationContext.refresh();

        applicationContext.publishEvent(new MySpringEvent("异步事件注解实现220417"));
        applicationContext.close();

    }

    @EventListener
    @Async
    public void onEvent(MySpringEvent event) {
        System.out.printf("[线程 ： %s] 监听到事件 : %s\n", Thread.currentThread().getName(), event);
    }

    @Bean
    public ExecutorService taskExecutor() {
        ExecutorService taskExecutor = newSingleThreadExecutor(new CustomizableThreadFactory("evan-event-thread-pool"));
        return taskExecutor;
    }

}
