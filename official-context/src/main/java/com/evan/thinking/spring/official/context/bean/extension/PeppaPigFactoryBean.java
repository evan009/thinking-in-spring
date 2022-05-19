package com.evan.thinking.spring.official.context.bean.extension;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

import com.evan.thinking.spring.official.context.model.PeppaPig;

/**
 * @desc: FactoryBean 示例
 * @author: evan 
 * @date: 2022/5/9
 */
@Configuration
public class PeppaPigFactoryBean implements FactoryBean<PeppaPig> {
    
    @Override
    public PeppaPig getObject() throws Exception {
        return PeppaPig.createPig();
    }

    @Override
    public Class<?> getObjectType() {
        return PeppaPig.class;
    }
}
