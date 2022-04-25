package com.evan.thinking.spring.official.context.model;

import org.springframework.core.io.Resource;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Desc: super
 * @author: evan
 * @date: 2022-03-24
 */
@Data
@Setter
@Getter
public class SuperPeppaPig extends PeppaPig {

    private String superRemark;

    private Resource resource;

}
