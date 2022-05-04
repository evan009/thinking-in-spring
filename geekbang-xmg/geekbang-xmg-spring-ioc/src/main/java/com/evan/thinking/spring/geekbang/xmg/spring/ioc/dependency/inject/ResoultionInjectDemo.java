package com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject;

import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject.anno.CustomeAutowired;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.dependency.inject.anno.CustomeInject;
import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: 依赖注入处理过程
 * @author: evan
 * @date: 2022/3/26
 */
public class ResoultionInjectDemo {

    /**
     * 实施查找+类型查找
     */
    @Autowired
    private User user;

    @Autowired
    @Lazy
    private User userLazy;

    @Inject
    private User userInject;

    @CustomeAutowired
    private User userCustomeAutowired;

    @CustomeInject
    private User userCustomeInject;

    @Autowired
    private Map<String, User> users;

    @Autowired
    private Optional<User> optionalUser;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResoultionInjectDemo.class);
        // 装配XML文件Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("META-INF/dependency-injection.xml");

        applicationContext.refresh();
        ResoultionInjectDemo resoultionInjectDemo = applicationContext.getBean(ResoultionInjectDemo.class);

        System.out.println(resoultionInjectDemo.user);
        System.out.println(resoultionInjectDemo.userLazy);
        System.out.println(resoultionInjectDemo.userInject);
        System.out.println(resoultionInjectDemo.users);
        System.out.println(resoultionInjectDemo.optionalUser.get());
        System.out.println(resoultionInjectDemo.userCustomeAutowired);
        System.out.println(resoultionInjectDemo.userCustomeInject);

        applicationContext.close();
    }

    // @Bean
    // public static AutowiredAnnotationBeanPostProcessor customeBeanPostProcesson() {
    // AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
    // Set<Class<? extends Annotation>> annotationTypes =
    // new LinkedHashSet<>(Arrays.asList(CustomeInject.class, Autowired.class, Inject.class));
    // beanPostProcessor.setAutowiredAnnotationTypes(annotationTypes);
    // return beanPostProcessor;
    // }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 3)
    public static AutowiredAnnotationBeanPostProcessor customeBeanPostProcesson() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setAutowiredAnnotationType(CustomeInject.class);
        return beanPostProcessor;
    }

}
