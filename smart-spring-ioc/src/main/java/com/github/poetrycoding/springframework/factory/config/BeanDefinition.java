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
     * 单例
     */
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    /**
     * 原型模式
     */
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    /**
     * beanClass对象定义
     */
    private Class beanClass;
    private PropertyValues propertyValues;

    /**
     * 对应xml init-method
     */
    private String initMethodName;

    /**
     * 对应xml destroy-method
     */
    private String destroyMethodName;

    /**
     * 生命周期默认为单例模式
     */
    private String scope = SCOPE_SINGLETON;

    /**
     * 单例
     */
    private boolean singleton = true;

    /**
     * 原型
     */
    private boolean prototype = false;


    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
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

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public boolean isSingleton() {
        return singleton;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    public boolean isPrototype() {
        return prototype;
    }

    public void setPrototype(boolean prototype) {
        this.prototype = prototype;
    }
}
