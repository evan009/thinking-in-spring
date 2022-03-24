package com.evan.thinking.spring.official.context.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPigPq;
import com.evan.thinking.spring.official.context.model.PeppaPigQz;

/**
 * @desc: 循环依赖
 * @author: evan
 * @date: 2022-03-24
 */
public class DependecyCircualDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-circual.xml");
        context.refresh();

        // 构造函数注入 根据名称，类型，索引
        PeppaPigPq peppaPigPq = context.getBean("pqProp", PeppaPigPq.class);
        System.out.println(peppaPigPq);
        System.out.println(peppaPigPq.getPeppaPigQz());
        PeppaPigQz peppaPigQz = context.getBean("qzProp", PeppaPigQz.class);
        System.out.println(peppaPigQz);

        context.close();

    }

}
