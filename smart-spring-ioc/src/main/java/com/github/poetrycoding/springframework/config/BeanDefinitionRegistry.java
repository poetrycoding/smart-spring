package com.github.poetrycoding.springframework.config;

import com.github.poetrycoding.springframework.exception.BeanDefinitionStoreException;

/**
 * Description: 定义对BeanDefinition 的各种增删改操作
 * <br/>
 * BeanDefinitionRegistry
 *
 * @author laiql
 * @date 2023/4/26 10:32
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册BeanDefinition
     *
     * @param beanName       名称
     * @param beanDefinition bean定义对象
     * @throws BeanDefinitionStoreException
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
            throws BeanDefinitionStoreException;
}
