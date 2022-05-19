package com.evan.thinking.spring.geekbang.xmg.data.binder;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: JavaBeans示例
 * @see java.beans.BeanInfo
 * @see java.beans.Introspector
 * @author: evan
 * @date: 2022/4/11
 */
public class JavaBeansDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {

            System.out.println(propertyDescriptor.toString());

        });

        Stream.of(beanInfo.getMethodDescriptors()).forEach(propertyDescriptor -> {

            System.out.println(propertyDescriptor.toString());

        });

        Stream.of(beanInfo.getBeanDescriptor()).forEach(propertyDescriptor -> {

            System.out.println(propertyDescriptor.toString());

        });

        Stream.of(beanInfo.getEventSetDescriptors()).forEach(propertyDescriptor -> {

            System.out.println(propertyDescriptor.toString());

        });
        System.out.println(beanInfo);
    }

}
