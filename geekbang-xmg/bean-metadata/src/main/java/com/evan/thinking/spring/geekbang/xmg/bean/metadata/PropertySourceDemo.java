package com.evan.thinking.spring.geekbang.xmg.bean.metadata;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: PropertySourc 示例
 * @author: evan
 * @date: 2022/4/5
 */
@PropertySource("classpath:/META-INF/user-properties.properties")
public class PropertySourceDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(PropertySourceDemo.class);

        Map<String, Object> source = new HashMap<>();
        source.put("user.name", "凉皮的爸爸");
        applicationContext.getEnvironment().getPropertySources()
            .addFirst(new MapPropertySource("map-resource", source));
        applicationContext.refresh();

        // beanName 和 bean 映射
        Map<String, User> usersMap = applicationContext.getBeansOfType(User.class);
        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            System.out.printf("User Bean name : %s , content : %s \n", entry.getKey(), entry.getValue());
        }
        System.out.println(applicationContext.getEnvironment().getPropertySources());

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
