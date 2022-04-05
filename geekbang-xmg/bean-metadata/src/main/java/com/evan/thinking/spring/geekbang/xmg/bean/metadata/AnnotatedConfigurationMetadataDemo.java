package com.evan.thinking.spring.geekbang.xmg.bean.metadata;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: Java 注解 配置元信息
 * @author: evan
 * @date: 2022/4/5
 */
@ImportResource("META-INF/dependency-lookup.xml")
@Import(UserBean.class)
@PropertySource("META-INF/user-properties.properties")
public class AnnotatedConfigurationMetadataDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotatedConfigurationMetadataDemo.class);
        applicationContext.refresh();

        // beanName 和 bean 映射
        Map<String, User> usersMap = applicationContext.getBeansOfType(User.class);
        for (Map.Entry<String, User> entry : usersMap.entrySet()) {
            System.out.printf("User Bean name : %s , content : %s \n", entry.getKey(), entry.getValue());
        }

        applicationContext.close();

    }

}
