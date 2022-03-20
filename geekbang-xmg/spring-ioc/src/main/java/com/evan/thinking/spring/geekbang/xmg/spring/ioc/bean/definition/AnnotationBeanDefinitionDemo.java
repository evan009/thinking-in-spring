package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import java.util.Map;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

@Import(AnnotationBeanDefinitionDemo.Config3.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationBeanDefinitionDemo.class, Config.class, Config2.class);

        // 通过 BeanDefinition 注册 API 实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext, "api");
        // 2. 非命名 Bean 的注册方法
        registerUserBeanDefinition(applicationContext, null);

        applicationContext.refresh();
        Map<String, Config> configBeans = applicationContext.getBeansOfType(Config.class);
        System.out.println(configBeans);
        Map<String, User> userBeans = applicationContext.getBeansOfType(User.class);
        System.out.println(userBeans);
        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", "011");
        beanDefinitionBuilder.addPropertyValue("name", "api");
        if (StringUtils.hasLength(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }

    }

    @Configuration
    public static class Config {

        @Bean(name = {"bean"})
        public User user() {
            User user = new User();
            user.setId("008");
            return user;
        }
    }

    @Component
    public static class Config2 {

        @Bean(name = {"Component"})
        public User user() {
            User user = new User();
            user.setId("009");
            return user;
        }
    }

    public static class Config3 {

        @Bean(name = {"import"})
        public User user() {
            User user = new User();
            user.setId("010");
            return user;
        }
    }
}
