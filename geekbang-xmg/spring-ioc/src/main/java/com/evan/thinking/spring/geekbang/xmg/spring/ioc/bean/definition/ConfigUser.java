package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConfigUser implements InitializingBean, DisposableBean {

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
    public void finalize() {
        System.out.println("垃圾回收");
    }
}
