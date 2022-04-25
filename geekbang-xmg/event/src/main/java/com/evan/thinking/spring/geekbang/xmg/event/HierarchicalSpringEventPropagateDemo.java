package com.evan.thinking.spring.geekbang.xmg.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @desc: 层次性Spring 上下文事件传播
 * @author: evan
 * @date: 2022/4/17
 */
public class HierarchicalSpringEventPropagateDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.register(MyListener.class);
        parentContext.setId("parentContext");

        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
        currentContext.register(MyListener.class);
        currentContext.setParent(parentContext);
        currentContext.setId("currentContext");

        parentContext.refresh();
        currentContext.refresh();

        parentContext.close();
        currentContext.close();

    }

    static class MyListener implements ApplicationListener<ContextRefreshedEvent> {

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.println(event.getApplicationContext().getId());
        }
    }

}
