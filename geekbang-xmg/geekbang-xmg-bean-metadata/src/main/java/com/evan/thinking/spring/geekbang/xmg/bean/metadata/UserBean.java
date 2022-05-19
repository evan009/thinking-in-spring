package com.evan.thinking.spring.geekbang.xmg.bean.metadata;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

@Configuration
public class UserBean {


    @Bean
    public User user(){
       return User.createUser();
    }
}
