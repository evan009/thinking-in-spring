package com.evan.thinking.spring.geekbang.xmg.event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.ErrorHandler;

/**
 * @desc: 事件异步API实现
 * @author: evan
 * @date: 2022/4/17
 */
public class AsyncEventHandlerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AsyncEventHandlerDemo.class);
        applicationContext.addApplicationListener(new MySpringEventListener());
        applicationContext.refresh();

        ApplicationEventMulticaster eventMulticaster = applicationContext.getBean(
            AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
        if (eventMulticaster instanceof SimpleApplicationEventMulticaster) {
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster =
                (SimpleApplicationEventMulticaster)eventMulticaster;
            ExecutorService taskExecutor = Executors.newSingleThreadExecutor();
            simpleApplicationEventMulticaster.setTaskExecutor(taskExecutor);

            // 监听容器关闭时间
            simpleApplicationEventMulticaster.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
                @Override
                public void onApplicationEvent(ApplicationEvent event) {
                    if (!taskExecutor.isShutdown()) {
                        taskExecutor.shutdown();
                    }
                }
            });

            simpleApplicationEventMulticaster.setErrorHandler(new ErrorHandler() {
                @Override
                public void handleError(Throwable t) {
                    System.out.println("异常处理   预警处理");
                }
            });
        }

        applicationContext.publishEvent(new MySpringEvent("异步事件API实现220417"));
        applicationContext.close();

    }

}
