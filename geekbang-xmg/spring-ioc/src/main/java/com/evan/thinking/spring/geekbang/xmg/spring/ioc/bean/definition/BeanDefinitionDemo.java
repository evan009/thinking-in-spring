package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.SuperUser;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

public class BeanDefinitionDemo {

    public static void main(String[] args) {

        // 通过 BeanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SuperUser.class);
        beanDefinitionBuilder.addPropertyValue("id", "009");
        beanDefinitionBuilder.addPropertyValue("name", "小羊苏西");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);

        // 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("id", "009")
                .add("name", "小羊苏西");
        System.out.println(genericBeanDefinition);


    }

}
