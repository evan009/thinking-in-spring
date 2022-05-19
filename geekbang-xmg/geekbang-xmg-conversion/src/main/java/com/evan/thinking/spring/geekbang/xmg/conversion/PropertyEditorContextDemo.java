package com.evan.thinking.spring.geekbang.xmg.conversion;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: PropertyEditor 集成 Spring 容器
 * @author: evan
 * @date: 2022/4/11
 */
public class PropertyEditorContextDemo {



    // AbstractApplicationContext -> "conversionService" ConversionService Bean
    // -> ConfigurableBeanFactory#setConversionService(ConversionService)
    // -> AbstractAutowireCapableBeanFactory.instantiateBean
    // -> AbstractBeanFactory#getConversionService ->
    // BeanDefinition -> BeanWrapper -> 属性转换（数据来源：PropertyValues）->
    // setPropertyValues(PropertyValues) -> TypeConverter#convertIfNecessnary
    // TypeConverterDelegate#convertIfNecessnary  -> PropertyEditor or ConversionService

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("classpath:/META-INF/properties-editor-context.xml");

        applicationContext.refresh();

        System.out.println(applicationContext.getBean(User.class));

        applicationContext.close();
    }

}
