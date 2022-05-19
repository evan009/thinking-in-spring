package com.evan.thinking.spring.official.context.bean.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @desc: 自定义 BeanFactoryPostProcessor
 * @author: evan
 * @date: 2022/5/9
 */
public class PeppaPigBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 可以覆盖应用上下文已经配置了的bean属性 bean 实例化之前 上下文敏感信息处理
     * <context:property-placeholder location="classpath:com/something/jdbc.properties"/>
     * PropertyOverrideConfigurer
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
