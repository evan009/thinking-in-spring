package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.scope;

import java.lang.annotation.Annotation;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class ThreadLocalScope implements Scope {

    private static final String SCOPE_NAME = "thread-local";


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return null;
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
