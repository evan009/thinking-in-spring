package com.evan.thinking.spring.official.context.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Desc: 小猪佩奇
 * @author: evan
 * @date: 2022-03-24
 */
@Getter
@Setter
@NoArgsConstructor
public class PeppaPigPq {

    private String id;

    private String name;

    private Integer age;

    private PeppaPigQz peppaPigQz;

    public PeppaPigPq(String name, Integer age, PeppaPigQz peppaPigQz) {
        this.name = name;
        this.age = age;
        this.peppaPigQz = peppaPigQz;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
