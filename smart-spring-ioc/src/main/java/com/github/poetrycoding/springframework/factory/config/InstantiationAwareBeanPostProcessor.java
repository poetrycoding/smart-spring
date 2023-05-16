package com.github.poetrycoding.springframework.factory.config;

import com.github.poetrycoding.springframework.exception.BeansException;

/**
 * Description: 实例化Bean处理器
 * * Subinterface of {@link BeanPostProcessor} that adds a before-instantiation callback,
 * * and a callback after instantiation but before explicit properties are set or
 * * autowiring occurs.
 * <br/>
 * InstantiationAwareBeanPostProcessor
 *
 * @author laiql
 * @date 2023/5/16 22:04
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     * <p>
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
