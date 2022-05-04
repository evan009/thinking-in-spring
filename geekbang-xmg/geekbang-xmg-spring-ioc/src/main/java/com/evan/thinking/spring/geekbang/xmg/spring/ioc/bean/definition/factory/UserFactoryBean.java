package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition.factory;

import org.springframework.beans.factory.FactoryBean;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: FactoryBean 实例化
 * @author: evan
 * @date: 2022/3/20
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
