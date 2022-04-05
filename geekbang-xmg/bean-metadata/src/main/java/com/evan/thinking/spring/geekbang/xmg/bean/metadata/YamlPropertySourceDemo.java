package com.evan.thinking.spring.geekbang.xmg.bean.metadata;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

/**
 * @desc: YamlMapFactoryBean 示例
 * @author: evan
 * @date: 2022/4/5
 */
public class YamlPropertySourceDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(YamlPropertySourceDemo.class);
        applicationContext.refresh();

        System.out.println(applicationContext.getBean("yamlMap"));

        applicationContext.close();
    }

    @Bean
    public YamlMapFactoryBean yamlMap() {
        YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
        yamlMapFactoryBean.setResources(new ClassPathResource("META-INF/user.yaml"));
        return yamlMapFactoryBean;
    }

}
