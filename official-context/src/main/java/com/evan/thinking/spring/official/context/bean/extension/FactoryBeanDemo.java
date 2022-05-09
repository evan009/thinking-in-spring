package com.evan.thinking.spring.official.context.bean.extension;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPig;

public class FactoryBeanDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(PeppaPigFactoryBean.class,FactoryBeanDemo.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("peppaPig"));
        applicationContext.close();
    }

}
