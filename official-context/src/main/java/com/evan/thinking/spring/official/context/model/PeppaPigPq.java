package com.evan.thinking.spring.official.context.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Desc: 小猪佩奇
 * @author: evan
 * @date: 2022-03-24
 */
@Getter
@Setter
@NoArgsConstructor
public class PeppaPigPq implements InitializingBean, DisposableBean {

    private String id;

    private String name;

    private Integer age;

    private PeppaPigQz peppaPigQz;


    public PeppaPigPq(String name, Integer age, PeppaPigQz peppaPigQz) {
        this.name = name;
        this.age = age;
        this.peppaPigQz = peppaPigQz;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 初始化");
    }

    @PostConstruct
    public void jsrInit() {
        System.out.println("@PostConstruct 初始化");
    }

    @PreDestroy
    public void jsrDestory() {
        System.out.println("@PreDestroy 初始化");
    }

    public void methodInit() {
        System.out.println("methodInit 初始化");
    }

    public void methodDestory() {
        System.out.println("methodDestory 初始化");
    }


}
