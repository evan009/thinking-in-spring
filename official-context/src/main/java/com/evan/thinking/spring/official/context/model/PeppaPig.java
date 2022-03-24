package com.evan.thinking.spring.official.context.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc: 小猪佩奇
 * @author: evan
 * @date: 2022-03-24
 */
@Data
@NoArgsConstructor
public class PeppaPig {

    private String id;

    private String name;

    private Integer age;

    private Properties hobby;

    private PeppaPigPq daughter;

    private List<String> someList;

    private Set<String> someSet;

    private Map<String, Object> someMap;

    private String nullStr;

    public PeppaPig(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static PeppaPig createPig() {
        PeppaPig pig = new PeppaPig();
        pig.setId("012");
        pig.setAge(null);
        pig.setName("静态方法实例化对象");
        return pig;
    }

}
