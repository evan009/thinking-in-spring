package com.evan.thinking.spring.geekbang.xmg.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @desc: Generic 示例
 * @author: evan
 * @date: 2022/4/11
 */
public class GenericDemo {

    public static void main(String[] args) {
        Collection<String> strList = new ArrayList<>();
        strList.add("evan");
        strList.add("220411");

        // 泛型擦写
        Collection tempList = strList;
        tempList.add(1);

        tempList.stream().forEach(temp -> {
            System.out.println(temp);
        });

    }

}
