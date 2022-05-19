package com.evan.thinking.spring.geekbang.xmg.validation;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: 错误文案示例
 * @author: evan
 * @date: 2022/4/10
 */
public class ErrorMessageDemo {

    public static void main(String[] args) {

        // 创建User对象
        User user = new User();
        user.setId("220410");
        user.setId("evan");
        // 1 选择errors
        Errors errors = new BeanPropertyBindingResult(user, "user");
        // 2 关联错误类
        errors.reject("user properties is not null");
        errors.rejectValue("name", "name.required", "用户名称");
        // 3 获取错误
        List<ObjectError> allErrors = errors.getAllErrors();
        // 4 通过 ObjectError code 和 arguments 关联 MessageSource
        MessageSource messageSource = createMessageSource();

        // 输出错误
        for (ObjectError error : allErrors) {
            System.out.println(messageSource.getMessage(error.getCode(), error.getArguments(), Locale.getDefault()));
        }
    }

    static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("user properties is not null", Locale.getDefault(), "用户属性不能为空");
        messageSource.addMessage("name.required", Locale.getDefault(), "用户名称不能为空");
        messageSource.addMessage("id.required", Locale.getDefault(), "用户标识不能为空");
        return messageSource;
    }

}
