package com.evan.thinking.spring.official.context.model;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Desc: FactoryBean 提供了动态实例化对象
 * @author: evan
 * @date: 2022-03-24
 */
public class PeppaPigFactoryBean implements FactoryBean<PeppaPig> {

    @Override
    public PeppaPig getObject() throws Exception {
        PeppaPig pig = new PeppaPig();
        pig.setId("012");
        pig.setAge(null);
        pig.setName("FactoryBean接口实例化对象");
        return pig;
    }

    @Override
    public Class<?> getObjectType() {
        return PeppaPig.class;
    }
}
