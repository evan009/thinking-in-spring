package com.evan.thinking.spring.geekbang.xmg.spring.ioc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String id;

    private String name;

    private Integer age;

    private Address addressAggr;

    public static User createUser() {
        User user = new User();
        user.setId("012");
        user.setName("createUser");

        return user;
    }


}
