package com.evan.thinking.spring.official.context.bean.annotation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.evan.thinking.spring.official.context.model.PeppaPig;

import lombok.ToString;

/**
 * @Desc: Qualifier 演示
 * @author: evan
 * @date: 2022-05-19
 */
public class QualifierMaster {

    @Autowired
    public QualifierMaster qualifierMaster;

    @Autowired
    @Qualifier("evan001")
    public Set<PeppaPig> peppaPigs;

    private PeppaPig pq;
    private PeppaPig qz;

    @Autowired
    public QualifierMaster(@Qualifier("evan001") PeppaPig pq, @Qualifier("evan002") PeppaPig qz) {
        this.pq = pq;
        this.qz = qz;
    }

}
