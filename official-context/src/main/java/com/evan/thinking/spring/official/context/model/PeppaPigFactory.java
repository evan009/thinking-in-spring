package com.evan.thinking.spring.official.context.model;

import lombok.Data;

/**
 * @desc: 创建小猪佩奇实例化工厂
 * @author: evan
 * @date: 2022-03-24
 */
@Data
public class PeppaPigFactory {

    public PeppaPig createPig() {
        PeppaPig pig = new PeppaPig();
        pig.setId("012");
        pig.setAge(null);
        pig.setName("实例化工厂实例化对象");
        return pig;
    }

}
