package com.evan.thinking.spring.official.context.model;

import org.springframework.beans.factory.BeanNameAware;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc: 小猪佩奇 声明周期延时类
 * @author: evan
 * @date: 2022-03-24
 */
@Data
@NoArgsConstructor
public class PeppaPigLifecycle implements BeanNameAware {

    private String id;

    private String name;

    private Integer age;

    private String beanName;


    public PeppaPigLifecycle(String name, Integer age, PeppaPigPq peppaPigPq) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

}
