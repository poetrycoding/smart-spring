package com.github.poetrycoding.springframework.factory.config;

import com.github.poetrycoding.springframework.exception.BeansException;

/**
 * Description: 在spring框架中用于修改Bean对象的扩展点
 * <br/>
 * BeanPostProcessor
 *
 * @author laiql
 * @date 2023/4/28 20:43
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化之前，执行此方法
     *
     * @param bean     bean对象
     * @param beanName 名称
     * @return 返回修改后的实例对象
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 用于修改Bean对象初始化方法之后，执行此方法
     *
     * @param bean     bean对象
     * @param beanName 名称
     * @return 返回修改后的实例对象
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
