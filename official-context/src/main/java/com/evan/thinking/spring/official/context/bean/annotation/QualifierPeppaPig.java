package com.evan.thinking.spring.official.context.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.evan.thinking.spring.official.context.model.PeppaPig;

import lombok.ToString;

/**
 * @Desc: Qualifier 演示
 * @author: evan
 * @date: 2022-05-19
 */
@ToString
public class QualifierPeppaPig {

    @Autowired
    @Qualifier("evan002")
    private PeppaPig peppaPig;

    @Bean
    @Primary
    @Qualifier(value = "evan001")
    public PeppaPig peppaPig() {
        PeppaPig peppaPig = PeppaPig.createPig();
        peppaPig.setName("Qualifier1演示");
        return peppaPig;
    }

    @Bean
    @Qualifier(value = "evan002")
    public PeppaPig peppaPig2() {
        PeppaPig peppaPig = PeppaPig.createPig();
        peppaPig.setName("Qualifier2演示");
        return peppaPig;
    }

    @Bean
    @Qualifier(value = "evan001")
    public PeppaPig peppaPig3() {
        PeppaPig peppaPig = PeppaPig.createPig();
        peppaPig.setName("Qualifier3演示");
        return peppaPig;
    }

}
