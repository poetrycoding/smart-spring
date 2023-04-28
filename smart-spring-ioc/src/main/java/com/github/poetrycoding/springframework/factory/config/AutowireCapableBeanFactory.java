package com.github.poetrycoding.springframework.factory.config;

import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.BeanFactory;

/**
 * Description:
 * * Extension of the {@link BeanFactory}
 * * interface to be implemented by bean factories that are capable of
 * * autowiring, provided that they want to expose this functionality for
 * * existing bean instances.
 * <br/>
 * AutowireCapableBeanFactory
 *
 * @author laiql
 * @date 2023/4/27 21:35
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean 现有的Bean对象
     * @param beanName     Bean名称
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean 现有的Bean对象
     * @param beanName     Bean名称
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;


}
