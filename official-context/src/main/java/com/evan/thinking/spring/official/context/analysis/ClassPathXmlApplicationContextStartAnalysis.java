package com.evan.thinking.spring.official.context.analysis;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc: {@link ClassPathXmlApplicationContext } 启动过程分析
 * @author: evan
 * @date: 2022/5/3
 * @see ClassPathXmlApplicationContext
 */
public class ClassPathXmlApplicationContextStartAnalysis {

    /**
     * https://github.com/seaswalker/spring-analysis/blob/1fab1b3e95f7d0b90eb6b41ee104c6b143954459/note/Spring.md#%E5%9F%BA%E6%9C%AC
     * @param args
     */
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-context.xml");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("META-INF/bean-context.xml");
        context.refresh();

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 自定义注册属性编辑器
        beanFactory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
            @Override
            public void registerCustomEditors(PropertyEditorRegistry registry) {

            }
        });

        System.out.println(context.getBean("pq"));

        context.close();

    }

}
