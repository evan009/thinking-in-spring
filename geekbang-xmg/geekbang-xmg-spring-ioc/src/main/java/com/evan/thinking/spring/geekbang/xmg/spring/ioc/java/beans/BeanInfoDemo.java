package com.evan.thinking.spring.geekbang.xmg.spring.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @desc: BeanInfo {@link java.beans.BeanInfo}
 * @author: evan
 * @date: 2022/3/19
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Account.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {

            propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);

            System.out.println(propertyDescriptor.toString());
        });

    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }

    }

}
