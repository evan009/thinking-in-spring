package com.evan.thinking.spring.official.context.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.evan.thinking.spring.official.context.model.PeppaPig;

/**
 * @Desc: Qualifier 容器示例
 * @author: evan
 * @date: 2022-05-19
 */
public class QualifierContextDemo {

    @Autowired
    private PeppaPig peppaPig2;

    /**
     * <p>
     *     @Target({ElementType.FIELD, ElementType.PARAMETER})
     *     @Retention(RetentionPolicy.RUNTIME)
     *     @Qualifier
     *     public @interface MovieQualifier {
     *
     *         String genre();
     *
     *         Format format();
     *     }
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(QualifierPeppaPig.class, QualifierContextDemo.class, QualifierMaster.class);

        context.refresh();

        QualifierContextDemo qualifierContextDemo = context.getBean(QualifierContextDemo.class);
        System.out.println(qualifierContextDemo.peppaPig2);

        QualifierMaster qualifierMaster = context.getBean(QualifierMaster.class);
        System.out.println(qualifierMaster);
        System.out.println(qualifierMaster.peppaPigs);
        System.out.println(qualifierMaster.qualifierMaster);

        QualifierPeppaPig qualifierPeppaPig = context.getBean(QualifierPeppaPig.class);
        System.out.println(qualifierPeppaPig);



        context.close();
    }

}
