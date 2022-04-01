package com.evan.thinking.spring.official.context.bean.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPigPq;

/**
 * @Desc: Bean 声明周期  基于XML配置
 * @author: evan
 * @date: 2022-04-01
 */
public class BeanLifecycleXmlDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/bean-lifecycle.xml");
        applicationContext.refresh();
        System.out.println(applicationContext.getBean(PeppaPigPq.class));
        applicationContext.close();

    }


}
