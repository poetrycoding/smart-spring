package com.github.poetrycoding.springframework.factory.support;

import com.github.poetrycoding.springframework.exception.BeanDefinitionStoreException;
import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;

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

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     * <p>
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
