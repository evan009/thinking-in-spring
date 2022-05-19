package com.evan.thinking.spring.geekbang.xmg.enviorment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * @desc: PropertySource 来源动态变更示例
 * @author: evan
 * @date: 2022/4/28
 */
public class PropertySourceChangeDemo {

    @Value("${user.name}")
    private String userName;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertySourceChangeDemo.class);

        ConfigurableEnvironment environment = context.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> source = new HashMap<>();
        source.put("user.name", "阿伟");
        MapPropertySource propertySource = new MapPropertySource("customize-propertySource", source);
        propertySources.addFirst(propertySource);
        context.refresh();
        source.put("user.name", "小刘");

        PropertySourceChangeDemo demo = context.getBean(PropertySourceChangeDemo.class);
        System.out.println(demo.userName);

        for (PropertySource<?> item : propertySources) {
            System.out.println(item);
        }

        context.close();

    }

}
