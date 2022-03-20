package com.evan.thinking.spring.geekbang.xmg.spring.ioc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @desc: TODO
 * @author: evan
 * @date: 2022/3/19
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@SuperAnno
public class SuperUser extends User {

    private String address;

}
