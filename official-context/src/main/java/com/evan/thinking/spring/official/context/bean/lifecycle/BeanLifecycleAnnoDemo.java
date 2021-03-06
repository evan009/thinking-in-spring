package com.evan.thinking.spring.official.context.bean.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.evan.thinking.spring.official.context.model.PeppaPigLifecycle;
import com.evan.thinking.spring.official.context.model.PeppaPigPq;
import com.evan.thinking.spring.official.context.model.PeppaPigQz;

/**
 * @Desc: Bean 声明周期
 * @author: evan
 * @date: 2022-04-01
 */
@EnableScheduling
public class BeanLifecycleAnnoDemo {

    /**
     * <pre>
     *     xml 可以在 default-init-method="methodInit" 提供默认的销毁初始化方法
     *     xml 可以在 default-destroy-method="methodDestory" 提供默认的销毁回调方法
     *     
     *     不要再容器声明周期的初始化方法中进行切面拦截
     *
     *     org.springframework.context.Lifecycle 回调接口声明
     *     org.springframework.context.SmartLifecycle
     *     org.springframework.context.support.DefaultLifecycleProcessor
     *
     *
     *     applicationContext.registerShutdownHook() == applicationContext.close();
     *
     *     Aware接口 可以接口注入关联  +  @Autowried依赖注入
     *     在普通 bean 属性填充之后，在诸如InitializingBean、 fterPropertiesSet 或自定义 init-method 等初始化回调之前调用该回调。
     *
     *
     *
     * </pre>
     * 
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanLifecycleAnnoDemo.class);
        applicationContext.getBeanFactory().addBeanPostProcessor(new CustomeBeanPostProcessor());
        applicationContext.refresh();
        // demo 初始化
        System.out.println(applicationContext.getBean(PeppaPigPq.class));
        // demo BeanPostProcessor
        System.out.println(applicationContext.getBean(PeppaPigQz.class));
        // demo Aware
        System.out.println(applicationContext.getBean(PeppaPigLifecycle.class));

        applicationContext.close();
        applicationContext.registerShutdownHook();
    }

    @Bean(initMethod = "methodInit", destroyMethod = "methodDestory")
    public PeppaPigPq peppaPigPq() {
        PeppaPigPq peppaPigPq = new PeppaPigPq();
        peppaPigPq.setId("220401");
        peppaPigPq.setName("peppaPigPq");
        return peppaPigPq;
    }

    @Bean
    public PeppaPigQz peppaPigQz() {
        PeppaPigQz peppaPigQz = new PeppaPigQz();
        return peppaPigQz;
    }

    @Bean
    public PeppaPigLifecycle PeppaPigLifecycle() {
        PeppaPigLifecycle peppaPigLifecycle = new PeppaPigLifecycle();
        return peppaPigLifecycle;
    }

}
