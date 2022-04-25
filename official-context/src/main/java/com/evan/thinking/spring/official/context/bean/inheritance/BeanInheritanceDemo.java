package com.evan.thinking.spring.official.context.bean.inheritance;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPig;

/**
 * @Desc: Bean 继承 实例
 * @author: evan
 * @date: 2022-04-01
 */
public class BeanInheritanceDemo {

    /**
     * <pre>
     *     Bean property 'xxx' is not writable or has an invalid setter method. Did you mean 'xxx'?
     *     xml工厂方法生成的bean bean继承有问题
     * </pre>
     * @param args
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("META-INF/bean-inheritance.xml");
        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(PeppaPig.class));

        applicationContext.close();

    }

}
