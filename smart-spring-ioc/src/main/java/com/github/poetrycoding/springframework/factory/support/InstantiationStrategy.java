package com.github.poetrycoding.springframework.factory.support;

import com.github.poetrycoding.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Description: Bean对象实例华策略
 * <br/>
 * InstanceStrategy
 *
 * @author laiql
 * @date 2023/4/26 20:57
 */
public interface InstantiationStrategy {
    /**
     * 实例化策略
     *
     * @param beanName    Bean名称
     * @param bd          Bean定义对象
     * @param constructor 构造函数对象
     * @param args        参数
     * @return 返回实例对象
     */
    Object instance(String beanName, BeanDefinition bd, Constructor constructor, Object[] args);
}
