package com.evan.thinking.spring.official.context.bean.annotation;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.evan.thinking.spring.official.context.model.PeppaPig;

import lombok.ToString;

/**
 * @desc: Autowired 注解使用方式
 * @author: evan
 * @date: 2022/5/18
 */
@ToString
public class AutowiredPeppaPig {

    private PeppaPig constructPeppaPig;

    private PeppaPig setterPeppaPig;

    private PeppaPig methodPeppaPig;

    @Autowired
    private PeppaPig filedPeppaPig;

    @Autowired
    public PeppaPig[] peppaPigArr;

    @Autowired
    public Optional<PeppaPig> movieFinder;

    @Autowired
    public Map<String, PeppaPig> peppaPigMap;

    @Autowired
    public Map<String, Object> allObject;

    @Autowired
    public AutowiredPeppaPig(PeppaPig constructPeppaPig) {
        this.constructPeppaPig = constructPeppaPig;
    }

    @Autowired
    public void setSetterPeppaPig(PeppaPig setterPeppaPig) {
        this.setterPeppaPig = setterPeppaPig;
    }

    public void methodPeppaPig(PeppaPig methodPeppaPig) {
        this.methodPeppaPig = methodPeppaPig;
    }
}
