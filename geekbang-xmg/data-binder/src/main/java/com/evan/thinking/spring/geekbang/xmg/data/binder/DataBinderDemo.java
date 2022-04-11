package com.evan.thinking.spring.geekbang.xmg.data.binder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.evan.thinking.spring.geekbang.xmg.spring.ioc.model.User;

/**
 * @desc: 数据绑定 示例
 * @see org.springframework.validation.DataBinder
 * @author: evan
 * @date: 2022/4/11
 */
public class DataBinderDemo {

    public static void main(String[] args) {

        // 创建空白对象
        User user = new User();
        // 1 创建数据绑定对象
        DataBinder dataBinder = new DataBinder(user, "user");
        // 2 创建PropertyValues对象
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        Map<String, Object> source = new HashMap<>();
        source.put("id", "220411");
        source.put("name", "阿伟");
        source.put("age", 18);
        // DataBinder 忽略未知属性
        source.put("city", "陇县");
        // DataBinder 嵌套对象 复合对象
        source.put("addressAggr.city", "陇县");
        propertyValues.addPropertyValues(source);

        // 3 数据绑定
        // 调整绑定策略
        // 3.1 忽略未知字段
        // dataBinder.setIgnoreUnknownFields(false);
        // 3.2 忽略错误字段
        dataBinder.setIgnoreInvalidFields(true);
        // 3.3 自动生成嵌套路径
        dataBinder.setAutoGrowNestedPaths(false);

        dataBinder.setRequiredFields("gender","性别也很重要呀");
        dataBinder.bind(propertyValues);
        System.out.println(user);


        // 4 获取绑定结果
        BindingResult bindingResult = dataBinder.getBindingResult();
        System.out.println(bindingResult);

    }

}
