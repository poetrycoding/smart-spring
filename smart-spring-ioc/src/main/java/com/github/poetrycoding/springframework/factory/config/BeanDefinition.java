package com.github.poetrycoding.springframework.factory.config;

import com.github.poetrycoding.springframework.property.PropertyValues;

/**
 * Description: Bean信息对象定义
 * <br/>
 * BeanDefinition
 *
 * @author laiql
 * @date 2023/4/26 09:57
 */
public class BeanDefinition {
    /**
     * beanClass对象定义
     */
    private Class beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
