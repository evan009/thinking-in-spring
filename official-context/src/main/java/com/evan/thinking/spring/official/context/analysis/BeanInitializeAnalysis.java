package com.evan.thinking.spring.official.context.analysis;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: Bean 初始化分析
 * @author: evan
 * @date: 2022/5/4
 */
public class BeanInitializeAnalysis {

    @Value("#{user.name}")
    private String UserName;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("META-INF/bean-context.xml");
        context.refresh();


        System.out.println(context.getBean("pq"));

        context.close();
    }

}
