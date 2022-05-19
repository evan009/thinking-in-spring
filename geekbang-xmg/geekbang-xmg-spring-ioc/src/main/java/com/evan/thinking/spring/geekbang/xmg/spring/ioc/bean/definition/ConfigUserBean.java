package com.evan.thinking.spring.geekbang.xmg.spring.ioc.bean.definition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@Configuration
public  class ConfigUserBean {

    @Bean(name = {"bean"}, initMethod = "initMethod", destroyMethod = "destroyMethod")
    @Lazy
    public ConfigUser user() {
        ConfigUser configUser = new ConfigUser();
        configUser.setName("ConfigUser");
        return configUser;
    }

}