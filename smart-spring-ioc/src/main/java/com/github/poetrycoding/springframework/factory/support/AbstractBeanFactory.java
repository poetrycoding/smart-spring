package com.github.poetrycoding.springframework.factory.support;

import com.github.poetrycoding.springframework.factory.BeanFactory;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;
import com.github.poetrycoding.springframework.exception.BeansException;

import java.util.Objects;

/**
 * Description:
 * BeanDefinition注册工厂，通过模版模式方式实现创建BeanDefinition和注册BeanDefinition，
 * 以及创建BeanDefinition对应的实例
 * <br/>
 * AbstractBeanFactory
 *
 * @author laiql
 * @date 2023/4/26 10:18
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    public <T> T doGetBean(final String beanName, Object[] args) {
        //从单例注册表一级缓存容器中获取实例对象
        Object singleton = getSingleton(beanName);
        if (Objects.nonNull(singleton)) {
            return (T) singleton;
        }
        //获取BeanDefinition对象
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        //根据BeanDefinition创建实例
        return (T) createBean(beanName, beanDefinition, args);
    }

    /**
     * 根据名称获取 BeanDefinition 对象
     *
     * @param beanName 名称
     * @return BeanDefinition
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    /**
     * 根据名称和BeanDefinition 创建对应Bean的实例
     *
     * @param beanName Bean名称
     * @param bd       BeanDefinition
     * @param args     参数
     * @return 实例对象
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition bd, Object[] args)
            throws BeansException;

}
