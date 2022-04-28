package com.evan.thinking.spring.official.context.resource;

/**
 * @Desc: 介绍
 * @author: evan
 * @date: 2022-04-07
 */
public class Introduce {

    /**
     * <pre>
     *     1: 接口 org.springframework.core.io.Resource
     *     2：内置实现
     *
     *     3：org.springframework.core.io.ResourceLoader
     *     4: org.springframework.context.ResourceLoaderAware
     *          通过Aware接口回调
     *          通过@Autowired注入
     *     5: 应用上下文集成
     *          通过字段注入Resource
     *          通配符引入资源 基于ant的正则表达式
     *          Thread.currentThread().getContextClassLoader().getResources()加载资源
     *
     * </pre>
     * 
     * @param args
     */

    public static void main(String[] args) {

//        SuperPeppaPig.class.getClass().getResource()

    }

}
