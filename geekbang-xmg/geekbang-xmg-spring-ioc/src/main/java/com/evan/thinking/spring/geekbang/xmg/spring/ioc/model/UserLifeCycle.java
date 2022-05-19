package com.evan.thinking.spring.geekbang.xmg.spring.ioc.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc: 用户声明周期
 * @author: evan
 * @date: 2022/4/5
 */
@Data
@NoArgsConstructor
public class UserLifeCycle implements BeanNameAware, InitializingBean, SmartInitializingSingleton, DisposableBean {

    private String id;

    private String remark;

    private String beanName;

    @PostConstruct
    public void init() {
        this.remark = "remark v4 @PostConstruct";
        System.out.println("v4 @PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.remark = "remark v5 InitializingBean#afterPropertiesSet";
        System.out.println("v5 InitializingBean#afterPropertiesSet");
    }

    public void initMethod() {
        this.remark = "remark v6 initMethod";
        System.out.println("v6 initMethod");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        this.remark = "remark v2 Aware 接口回调";
        System.out.println("v2 BeanNameAware 初始化");
    }

    @Override
    public void afterSingletonsInstantiated() {
        this.remark = "remark v8 SmartInitializingSingleton#afterSingletonsInstantiated";
        System.out.println("v8 SmartInitializingSingleton#afterSingletonsInstantiated");
    }

    @PreDestroy
    public void preDestroy() {
        this.remark = "remark v10  @PreDestroy";
        System.out.println("v10  @PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        this.remark = "remark v11 DisposableBean#destroy";
        System.out.println("v11     DisposableBean#destroy");
    }

    public void destroyMethod() {
        this.remark = "remark v12  destroyMethod";
        System.out.println("v12  destroyMethod");
    }


    @Override
    protected void finalize() throws Throwable {
        this.remark = "remark v13  finalize";
        System.out.println("v13  finalize");
    }

}
