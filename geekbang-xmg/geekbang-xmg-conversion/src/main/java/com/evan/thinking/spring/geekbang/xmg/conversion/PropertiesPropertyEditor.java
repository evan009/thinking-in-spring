package com.evan.thinking.spring.geekbang.xmg.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.StringReader;
import java.util.Properties;

/**
 * @desc: String -- > Properties 示例
 * @author: evan
 * @date: 2022/4/11
 */
public class PropertiesPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

    @lombok.SneakyThrows
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        Properties properties = new Properties();
        properties.load(new StringReader(text));
        setValue(properties);

    }

}
