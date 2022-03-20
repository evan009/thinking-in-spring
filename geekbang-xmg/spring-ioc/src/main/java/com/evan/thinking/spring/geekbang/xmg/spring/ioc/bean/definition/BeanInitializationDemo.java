package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import lombok.Data;
import lombok.NoArgsConstructor;

public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class, Config.class);
        applicationContext.refresh();
        System.out.println("容器已启动...");

        System.out.println(applicationContext.getBean(ConfigUser.class));
        System.out.println("容器准备关闭...");
        applicationContext.close();
        System.out.println("容器已关闭...");

    }

    @Configuration
    public static class Config {

        @Bean(name = {"bean"}, initMethod = "initMethod", destroyMethod = "destroyMethod")
        @Lazy
        public ConfigUser user() {
            ConfigUser configUser = new ConfigUser();
            configUser.setName("ConfigUser");
            return configUser;
        }

    }

    @Data
    @NoArgsConstructor
    public static class ConfigUser implements InitializingBean, DisposableBean {

        private String name;

        @PostConstruct
        public void init() {
            System.out.println("PostConstruct执行");
        }

        @PreDestroy
        public void destory() {
            System.out.println("PreDestroy执行");
        }

        private void initMethod() {
            System.out.println("initMethod执行");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("DisposableBean执行");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("InitializingBean执行");
        }

        private void destroyMethod() {
            System.out.println("destroyMethod执行");
        }

        @Override
        public void finalize(){
            System.out.println("垃圾回收");
        }
    }

}
