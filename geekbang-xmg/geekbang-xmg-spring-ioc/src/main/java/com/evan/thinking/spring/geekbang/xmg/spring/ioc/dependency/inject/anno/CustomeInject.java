package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject.anno;

import java.lang.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 自定义注入注解
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CustomeInject {
}
