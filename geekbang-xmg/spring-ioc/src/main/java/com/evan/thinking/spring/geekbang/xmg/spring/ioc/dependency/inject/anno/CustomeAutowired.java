package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject.anno;

import java.lang.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 扩展Autowired 方法
 * 
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Autowired
public @interface CustomeAutowired {}
