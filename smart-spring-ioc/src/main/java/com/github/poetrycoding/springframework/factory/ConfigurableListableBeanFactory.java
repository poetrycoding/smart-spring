package com.github.poetrycoding.springframework.factory;

import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.config.AutowireCapableBeanFactory;
import com.github.poetrycoding.springframework.factory.config.BeanDefinition;
import com.github.poetrycoding.springframework.factory.config.ConfigurableBeanFactory;

/**
 * Description:
 * * Configuration interface to be implemented by most listable bean factories.
 * * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * * analyze and modify bean definitions, and to pre-instantiate singletons.
 * <br/>
 * ConfigurableListableBeanFactory
 *
 * @author laiql
 * @date 2023/4/27 21:33
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
