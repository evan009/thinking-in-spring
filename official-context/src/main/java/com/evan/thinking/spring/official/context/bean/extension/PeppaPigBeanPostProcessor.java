package com.evan.thinking.spring.official.context.bean.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @desc: 自定义BeanPostProcessor
 * @author: evan
 * @date: 2022/5/9
 */
public class PeppaPigBeanPostProcessor implements BeanPostProcessor, Ordered {

    /**
     * 初始化前执行
     * 
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + beanName);
        System.out.println("postProcessBeforeInitialization " + bean);
        return bean;
    }

    /**
     * 初始化后执行
     * 
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization  " + beanName);
        System.out.println("postProcessAfterInitialization  " + bean);
        return null;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
