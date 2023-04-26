package com.github.poetrycoding.springframework.factory;

import com.github.poetrycoding.springframework.config.BeanDefinition;
import com.github.poetrycoding.springframework.exception.BeansException;

/**
 * Description: 综合AbstractBeanFacto1y 并对接口AutowireCapableBeanFactory 进行实现。
 * <br/>
 * AbstractAutowireCapableBeanFactory
 *
 * @author laiql
 * @date 2023/4/26 10:25
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition bd) throws BeansException {
        Object singletonBeanInstance;
        try {
            singletonBeanInstance = bd.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Failed to instantiate Bean object", e);
        }
        //注册到单例容器中
        registerSingleton(beanName, singletonBeanInstance);
        return singletonBeanInstance;
    }
}
