package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.UserLifeCycle;

/**
 * @desc: Bean BeanPostProcessor
 * @author: evan
 * @date: 2022/3/31
 */
public class UserLifecycleBeanPostProcessor implements BeanPostProcessor, DestructionAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAssignableFrom(UserLifeCycle.class) && "UserLifeCycle".equals(beanName)) {
            UserLifeCycle userLifeCycle = (UserLifeCycle)bean;
            userLifeCycle.setRemark("remark v3 BeanPostProcessor#postProcessBeforeInitialization");
            System.out.println("v3 postProcessBeforeInitialization 初始化");
            return userLifeCycle;
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAssignableFrom(UserLifeCycle.class) && "UserLifeCycle".equals(beanName)) {
            UserLifeCycle userLifeCycle = (UserLifeCycle)bean;
            userLifeCycle.setRemark("remark BeanPostProcessor#postProcessAfterInitialization");
            System.out.println("v7 BeanPostProcessor#postProcessAfterInitialization 初始化");
            return userLifeCycle;
        }
        return null;
    }

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAssignableFrom(UserLifeCycle.class) && "UserLifeCycle".equals(beanName)) {
            UserLifeCycle userLifeCycle = (UserLifeCycle)bean;
            userLifeCycle.setRemark("remark v9 DestructionAwareBeanPostProcessor#postProcessAfterInitialization");
            System.out.println("v9 DestructionAwareBeanPostProcessor#postProcessAfterInitialization 销毁");
        }
    }
}
