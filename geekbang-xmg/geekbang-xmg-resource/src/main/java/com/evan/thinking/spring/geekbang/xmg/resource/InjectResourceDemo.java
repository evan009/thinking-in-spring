package com.evan.thinking.spring.geekbang.xmg.resource;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @desc: 注入Resource示例
 * @author: evan
 * @date: 2022/4/9
 */
public class InjectResourceDemo {


    @Value("classpath:/META-INF/default.properties")
    private  Resource resource;
    @Value("classpath:/META-INF/default-prod.properties")
    private  Resource prodResource;

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectResourceDemo.class);
        applicationContext.refresh();
        applicationContext.close();


    }


    @PostConstruct
    public void init() throws IOException {
        System.out.println(resource);
        System.out.println(IOUtils.toString(new EncodedResource(resource,"UTF-8").getReader()));
        System.out.println(IOUtils.toString(new EncodedResource(prodResource,"UTF-8").getReader()));
    }


}
