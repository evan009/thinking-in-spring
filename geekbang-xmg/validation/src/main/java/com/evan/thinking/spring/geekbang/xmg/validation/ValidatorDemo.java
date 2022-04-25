package com.evan.thinking.spring.geekbang.xmg.validation;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.validation.*;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

import static com.evan.thinking.spring.geekbang.xmg.validation.ErrorMessageDemo.createMessageSource;

/**
 * @desc: 自定义 {@link org.springframework.validation.Validator}
 * @author: evan
 * @date: 2022/4/10
 */
public class ValidatorDemo {

    public static void main(String[] args) {

        UserValidator userValidator = new UserValidator();
        User user = new User();
        user.setId("220410");
        System.out.println("userValidator.supports" + userValidator.supports(user.getClass()));
        Errors errors = new BeanPropertyBindingResult(user, "user");
        userValidator.validate(user,errors);
        List<ObjectError> allErrors = errors.getAllErrors();
        MessageSource messageSource = createMessageSource();
        // 输出错误
        for (ObjectError error : allErrors) {
            System.out.println(messageSource.getMessage(error.getCode(),error.getArguments(), Locale.getDefault()));
        }

    }

    static class UserValidator implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        }
    }

}
