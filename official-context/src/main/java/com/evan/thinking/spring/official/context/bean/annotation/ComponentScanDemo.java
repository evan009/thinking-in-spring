package com.evan.thinking.spring.official.context.bean.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Desc: ComponentScan 排除
 * @author: evan
 * @date: 2022-05-24
 */
@Configuration
@ComponentScan(
    includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX,
        pattern = {"com.evan.thinking.spring.official.context.*projectName.*fileName"})},
    excludeFilters = {@ComponentScan.Filter(Configuration.class)})

public class ComponentScanDemo {}
