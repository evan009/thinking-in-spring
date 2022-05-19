package com.evan.thinking.spring.geekbang.xmg.spring.ioc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc: 地址对象
 * @author: evan
 * @date: 2022/4/11
 */
@Data
@NoArgsConstructor
public class Address {

    private String province;

    private String city;

    private String area;

}
