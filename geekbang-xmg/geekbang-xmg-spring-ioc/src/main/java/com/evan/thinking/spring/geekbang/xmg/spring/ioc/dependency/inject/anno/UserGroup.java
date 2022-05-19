package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject.anno;

import java.lang.annotation.*;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 用户组注解，扩展 {@link Qualifier @Qualifier}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
public @interface UserGroup {
}
