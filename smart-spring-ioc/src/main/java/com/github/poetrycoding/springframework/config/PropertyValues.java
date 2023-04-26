package com.github.poetrycoding.springframework.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 属性包装，对属性的CRUD
 * <br/>
 * PropertyValues
 *
 * @author laiql
 * @date 2023/4/26 22:38
 */
public class PropertyValues {
    /**
     * 存储属性集合
     */
    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValues.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : propertyValues) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
