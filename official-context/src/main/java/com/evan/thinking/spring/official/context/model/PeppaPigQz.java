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
public class PeppaPigQz {

    private String id;

    private String name;

    private Integer age;

    private PeppaPigPq peppaPigPq;

    public PeppaPigQz(String name, Integer age, PeppaPigPq peppaPigPq) {
        this.name = name;
        this.age = age;
        this.peppaPigPq = peppaPigPq;
    }

    @Override
    public String toString() {
        return "PeppaPigQz{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age=" + age + ", peppaPigPq="
            + peppaPigPq + '}';
    }

}
