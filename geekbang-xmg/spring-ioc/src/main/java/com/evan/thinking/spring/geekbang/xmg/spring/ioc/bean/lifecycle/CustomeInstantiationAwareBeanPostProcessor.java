package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.SuperUser;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

public class CustomeInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化之前构建实例对象
     * 
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
            // 把配置完成 superUser Bean 覆盖
            return new SuperUser();
        }
        return null; // 保持 Spring IoC 容器的实例化操作
    }

    /**
     * 实例化之后构建实例对象
     * 
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (User.class.equals(bean.getClass()) && "user1".equals(beanName)) {
            User user = (User)bean;
            user.setId("220331");
            user.setName("postProcessAfterInitialization");
            return false;
        }
        return true;
    }

    /**
     * 组装好之前修改属性
     * 
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
        throws BeansException {
        if (User.class.equals(bean.getClass()) && "user2".equals(beanName)) {
            final MutablePropertyValues propertyValues;

            if (pvs instanceof MutablePropertyValues) {
                propertyValues = (MutablePropertyValues)pvs;
            } else {
                propertyValues = new MutablePropertyValues();
            }
            propertyValues.addPropertyValue("name", "postProcessProperties");
            return propertyValues;
        }
        return null;
    }
}
