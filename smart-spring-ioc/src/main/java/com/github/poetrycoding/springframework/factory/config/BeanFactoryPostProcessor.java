package com.github.poetrycoding.springframework.factory.config;

import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.ConfigurableListableBeanFactory;

/**
 * Description: 用于自定义修改 BeanDefinition属性信息
 * <br/>
 * BeanFactoryPostProcessor
 *
 * @author laiql
 * @date 2023/4/28 20:47
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory 上下文工厂
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
