package com.evan.thinking.spring.geekbang.xmg.bean.metadata;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: Bean 配置元信息 示例
 * @author: evan
 * @date: 2022/4/5
 */
public class BeanConfigurationMetadataDemo {

    public static void main(String[] args) {

        // BeanDefinition 定义
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // Bean 属性赋值
        definitionBuilder.addPropertyValue("name", "evan");
        BeanDefinition definition = definitionBuilder.getBeanDefinition();
        // 附加属性 不影响Bean populate initialize
        definition.setAttribute("name", "220405");
        definition.setAttribute("age", 18);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if (bean.getClass().equals(User.class) && "user".equals(beanName)) {
                    BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
                    User user = (User) bean;
                    user.setName((String) bd.getAttribute("name"));
                    user.setAge((Integer) bd.getAttribute("age"));
                    return user;
                }
                return null;
            }
        });
        beanFactory.registerBeanDefinition("user", definitionBuilder.getBeanDefinition());

        System.out.println(beanFactory.getBean(User.class));

    }

}
