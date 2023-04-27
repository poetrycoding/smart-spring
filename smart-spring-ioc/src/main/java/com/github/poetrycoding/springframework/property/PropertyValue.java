package com.github.poetrycoding.springframework.property;

/**
 * Description: 属性对象定义
 * <br/>
 * PropertyValue
 *
 * @author laiql
 * @date 2023/4/26 22:39
 */
public class PropertyValue {
    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性值
     */
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
