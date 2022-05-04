package com.evan.thinking.spring.geekbang.xmg.bean.metadata;

import java.io.IOException;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

/**
 * @desc: 自定义 YAML 的 PropertySourceFactory
 * @author: evan
 * @date: 2022/4/5
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean propertiesFactoryBean = new YamlPropertiesFactoryBean();
        propertiesFactoryBean.setResources(resource.getResource());
        return new PropertiesPropertySource(name, propertiesFactoryBean.getObject());
    }

}
