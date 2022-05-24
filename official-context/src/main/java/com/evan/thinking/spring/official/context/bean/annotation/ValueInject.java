package com.evan.thinking.spring.official.context.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Desc: @Value 注解示例
 * @author: evan
 * @date: 2022-05-19
 */
@Component
public class ValueInject {

    public String methodUserName;
    public String setterUserName;
    @Value("${user.name}")
    public String filedUserName;

    @Autowired
    public void methodUserName(@Value("${user.name}") String userName) {
        methodUserName = userName;
    }

    @Autowired
    public void setSetterUserName(@Value("${user.name}") String userName) {
        setterUserName = userName;
    }

}
