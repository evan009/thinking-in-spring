package com.evan.thinking.spring.geekbang.xmg.validation;

import java.util.Locale;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import lombok.Data;



/**
 * @desc: Spring Bean 整合示例
 * @author: evan
 * @date: 2022/4/10
 */
public class SpringBeanValidationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringBeanValidationDemo.class, UserProcessor.class);
        applicationContext.refresh();
        // System.out.println(applicationContext.getBean(Validator.class));
        // System.out.println(applicationContext.getBean(MethodValidationPostProcessor.class));
        UserProcessor userProcessor = applicationContext.getBean(UserProcessor.class);
        userProcessor.process(new UserValidator());
        applicationContext.close();

    }

    @Bean
    public Validator LocalValidatorFactoryBean() {
        LocalValidatorFactoryBean  validator = new  LocalValidatorFactoryBean();
        validator.setValidationMessageSource(createMessageSource());
        return validator;
    }

    @Bean
    public MethodValidationPostProcessor validationPostProcessor(Validator validator) {
        MethodValidationPostProcessor validationPostProcessor = new MethodValidationPostProcessor();
        validationPostProcessor.setValidator(validator);
        return validationPostProcessor;
    }

    @Component
    @Validated
    static class UserProcessor {

        public void process(@Valid UserValidator userValidator) {
            System.out.println(userValidator);
        }

    }

    @Data
    static class UserValidator {

        @NotNull
        private String id;

        @NotBlank
        private String name;

    }

    static MessageSource createMessageSource() {
        StaticMessageSource messageSource = new StaticMessageSource();
        messageSource.addMessage("process.userValidator.id", Locale.getDefault(), "国际化用户名称不能为空");
        messageSource.addMessage("process.userValidator.name", Locale.getDefault(), "国际化用户标识不能为空");
        return messageSource;
    }

}
