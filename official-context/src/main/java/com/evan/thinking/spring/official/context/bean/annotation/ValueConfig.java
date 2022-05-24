package com.evan.thinking.spring.official.context.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.format.support.DefaultFormattingConversionService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * @Desc: @Value 注解示例
 * @author: evan
 * @date: 2022-05-19
 */
@Configuration
@PropertySource("classpath:application.properties")
@Data
public class ValueConfig {

    @Value("${customize.key}")
    private String key;

    @Value("${customize.jsonObj}")
    private JSONObject jsonObject;

    @Value("${customize.jsonArr}")
    private JSONArray jsonArray;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public static ConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StrToJsonObjConvert());
        conversionService.addConverter(new StrToJsonArrConvert());
        return conversionService;
    }

}

class StrToJsonObjConvert implements Converter<String, JSONObject> {

    @Override
    public JSONObject convert(String source) {
        return JSONObject.parseObject(source);
    }
}

class StrToJsonArrConvert implements Converter<String, JSONArray> {

    @Override
    public JSONArray convert(String source) {
        return JSONObject.parseArray(source);
    }
}