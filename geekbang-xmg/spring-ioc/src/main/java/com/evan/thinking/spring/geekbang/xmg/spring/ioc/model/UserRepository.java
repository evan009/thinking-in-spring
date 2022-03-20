package com.evan.thinking.spring.geekbang.xmg.spring.ioc.model;

import java.util.Collection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<User> objectFactoryUser;

    private ObjectFactory<ApplicationContext> objectFactoryContext;

}
