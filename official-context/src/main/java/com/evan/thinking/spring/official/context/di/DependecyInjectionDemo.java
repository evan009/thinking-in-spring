package com.evan.thinking.spring.official.context.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPig;

/**
 * @Desc: 依赖注入示例
 * 
 *        <pre>
 *          构造函数注入：官方推荐，原因是可以保证Bean给客户端的是完整的，依赖性是不能为空的。构造函数可能会存在循环依赖。
 *          属性注入：确定就是依赖性有可能为空，难搞。优势是可以重新配置和注入实例。例如JMX？
 *          三方框架就不要给用户setter注入了。
 *        </pre>
 * 
 * @author: evan
 * @date: 2022-03-24
 */
public class DependecyInjectionDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean-di.xml");
        context.refresh();

        // 构造函数注入 根据名称，类型，索引
        System.out.println(context.getBean("pqFather", PeppaPig.class));
        // 构造器 C 命名空间
        System.out.println(context.getBean("pqFatherByCNameSpace", PeppaPig.class));
        // 属性注入
        System.out.println(context.getBean("pqMother", PeppaPig.class));
        // System.out.println(context.getBean("daughterPig", PeppaPigPq.class));

        // 属性注入 P 命名空间
        System.out.println(context.getBean("pqMotherByPNameSpace", PeppaPig.class));

        context.close();

    }

}
