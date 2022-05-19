package com.evan.thinking.spring.geekbang.xmg.conversion;

import java.util.Properties;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: 自定义注册 {@link PropertyEditorRegistrar}
 * @author: evan
 * @date: 2022/4/11
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {

        registry.registerCustomEditor(Properties.class, "context", new PropertiesPropertyEditor());

    }
}
