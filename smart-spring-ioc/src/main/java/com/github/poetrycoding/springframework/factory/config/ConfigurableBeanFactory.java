package com.github.poetrycoding.springframework.factory.config;

import com.github.poetrycoding.springframework.factory.BeanFactory;
import com.github.poetrycoding.springframework.factory.HierarchicalBeanFactory;

/**
 * Description:
 * * Configuration interface to be implemented by most bean factories. Provides
 * * facilities to configure a bean factory, in addition to the bean factory
 * * client methods in the {@link BeanFactory}
 * * interface.
 * <br/>
 * ConfigurableBeanFactory
 *
 * @author laiql
 * @date 2023/4/27 21:36
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

}
