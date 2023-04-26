package com.github.poetrycoding.springframework.config;

/**
 * Description: Bean的引用
 * <br/>
 * BeanReference
 *
 * @author laiql
 * @date 2023/4/26 22:47
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
