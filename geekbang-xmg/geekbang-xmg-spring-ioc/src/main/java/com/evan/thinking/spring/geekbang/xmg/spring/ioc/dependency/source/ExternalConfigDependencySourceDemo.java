package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @desc: 外部化配置依赖来源
 * @author: evan
 * @date: 2022/3/27
 */
@Configuration
@PropertySource("META-INF/default.properties")
public class ExternalConfigDependencySourceDemo {

    @Value("${user.name:凉皮}")
    private String id;
    @Value("${user.resource:META-INF/default.properties}")
    private Resource resource;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigDependencySourceDemo.class);

        applicationContext.refresh();
        ExternalConfigDependencySourceDemo demo =  applicationContext.getBean(ExternalConfigDependencySourceDemo.class);


        System.out.println(demo.id);
        System.out.println(demo.resource);
        
        applicationContext.close();

    }

}
