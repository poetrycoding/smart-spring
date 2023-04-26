package com.github.poetrycoding.springframework.config;

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

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
