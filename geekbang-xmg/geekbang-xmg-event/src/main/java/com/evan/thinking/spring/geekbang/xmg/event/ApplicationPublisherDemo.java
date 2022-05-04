package com.evan.thinking.spring.geekbang.xmg.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @desc: Spring ApplicationListener 事件
 * @author: evan
 * @date: 2022/4/17
 */
@EnableAsync
public class ApplicationPublisherDemo implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationPublisherDemo.class);
        applicationContext.refresh();

        applicationContext.close();

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        eventPublisher.publishEvent(" PayloadApplicationEvent ");
    }
}
