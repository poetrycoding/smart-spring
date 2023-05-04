package com.github.poetrycoding.springframework.factory;

import com.github.poetrycoding.springframework.exception.BeansException;

/**
 * Description: 容器感知接口
 * <br/>
 * BeanFactoryAware
 *
 * @author laiql
 * @date 2023/5/4 16:25
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
