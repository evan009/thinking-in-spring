package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition.factory;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }
}