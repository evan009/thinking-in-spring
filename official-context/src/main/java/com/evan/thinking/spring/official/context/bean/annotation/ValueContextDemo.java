package com.evan.thinking.spring.official.context.bean.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc: @Value 注解示例
 * @author: evan
 * @date: 2022-05-19
 */
public class ValueContextDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ValueInject.class, ValueConfig.class);;

        context.refresh();

        ValueInject valueInject = context.getBean(ValueInject.class);

        System.out.println(valueInject.filedUserName);
        System.out.println(valueInject.methodUserName);
        System.out.println(valueInject.setterUserName);


        ValueConfig valueConfig = context.getBean(ValueConfig.class);
        System.out.println(valueConfig.getKey());
        System.out.println(valueConfig.getJsonObject());
        System.out.println(valueConfig.getJsonArray());


        System.out.println(valueConfig.getEnvironment().getProperty("customize.key"));


        context.close();

    }

}
