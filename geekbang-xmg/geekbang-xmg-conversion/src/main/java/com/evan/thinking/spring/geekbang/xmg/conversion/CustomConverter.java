package com.evan.thinking.spring.geekbang.xmg.conversion;

import java.util.Collections;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.Converter;

/**
 * @desc: 自定义实现 {@link ConditionalGenericConverter}
 * @see Converter
 * @author: evan
 * @date: 2022/4/11
 */
public class CustomConverter implements ConditionalGenericConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType.getObjectType().equals(Properties.class) && targetType.getObjectType().equals(String.class);
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(Properties.class, String.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Properties properties = (Properties)source;
        System.out.println("自定义实现convert");
        return properties.toString();
    }
}
