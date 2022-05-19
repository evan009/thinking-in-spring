package com.evan.thinking.spring.geekbang.xmg.bean.metadata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: YamlMapFactoryBean 示例
 * @author: evan
 * @date: 2022/4/5
 */
@PropertySource(name = "yamlProperties", value = "classpath:/META-INF/user.yaml", encoding = "UTF-8",
    factory = YamlPropertySourceFactory.class)
public class YamlPropertySourceAnnoDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(YamlPropertySourceAnnoDemo.class);
        applicationContext.refresh();

        System.out.println(applicationContext.getBean(User.class));

        applicationContext.close();
    }

    @Bean
    public User user(@Value("${user.name}") String name, @Value("${user.id}") String id) {
        User user = new User();
        user.setName(name);
        user.setId(id);
        return user;
    }

}
