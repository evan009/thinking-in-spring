package com.evan.thinking.spring.official.context.bean.scop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.evan.thinking.spring.official.context.model.PeppaPigQz;

/**
 * @Desc: 自定义BeanPostProcessor {@link BeanPostProcessor}
 * @author: evan
 * @date: 2022-04-01
 */
public class CustomeBeanPostProcessor implements BeanPostProcessor {

    /**
     * 实例化前
     * 
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().equals(PeppaPigQz.class)) {
            PeppaPigQz peppaPigQz = new PeppaPigQz();
            peppaPigQz.setId("220401Qz");
            peppaPigQz.setName("postProcessBeforeInitialization");
            return peppaPigQz;
        }
        return bean;
    }

    /**
     * 实例化后
     * 
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().equals(PeppaPigQz.class)) {
            PeppaPigQz peppaPigQz = new PeppaPigQz();
            peppaPigQz.setId("220401Qz");
            peppaPigQz.setName("postProcessAfterInitialization");
            peppaPigQz.setAge(25);
            return peppaPigQz;
        }
        return bean;
    }

}
