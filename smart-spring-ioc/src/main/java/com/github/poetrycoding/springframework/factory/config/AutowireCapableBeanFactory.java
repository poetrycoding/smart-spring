package com.github.poetrycoding.springframework.factory.config;

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
}
