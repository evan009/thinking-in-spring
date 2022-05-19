package com.evan.thinking.spring.geekbang.xmg.conversion;

import java.util.Properties;

/**
 * @desc: PropertyEditor 示例
 * @see java.beans.PropertyEditor
 * @see java.beans.PropertyEditorSupport
 * @author: evan 
 * @date: 2022/4/11
 */ 
public class PropertyEditorDemo {

    public static void main(String[] args) {

        String orgin = "name=evan";

        PropertiesPropertyEditor stringToPropertiesPropertyEditor = new PropertiesPropertyEditor();
        stringToPropertiesPropertyEditor.setAsText(orgin);
        Properties properties = (Properties) stringToPropertiesPropertyEditor.getValue();

        System.out.println(properties);

    }


}
