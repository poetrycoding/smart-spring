package com.github.poetrycoding.springframework.factory;

import com.github.poetrycoding.springframework.config.BeanDefinition;
import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.support.InstanceStrategy;
import com.github.poetrycoding.springframework.support.JdkSubclassingInstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * Description: 综合AbstractBeanFacto1y 并对接口AutowireCapableBeanFactory 进行实现。
 * <br/>
 * AbstractAutowireCapableBeanFactory
 *
 * @author laiql
 * @date 2023/4/26 10:25
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstanceStrategy instanceStrategy = new JdkSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition bd, Object[] args) throws BeansException {
        Object singletonBeanInstance;
        try {
            singletonBeanInstance = createBeanInstance(beanName, bd, args);
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate Bean object", e);
        }
        //注册到单例容器中
        registerSingleton(beanName, singletonBeanInstance);
        return singletonBeanInstance;
    }

    private Object createBeanInstance(String beanName, BeanDefinition bd, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = bd.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (null != args && declaredConstructor.getParameterTypes().length == args.length) {
                constructorToUse = declaredConstructor;
                break;
            }
        }
        //调用创建实例创建对象
        return getInstanceStrategy().instance(beanName, bd, constructorToUse, args);
    }

    public InstanceStrategy getInstanceStrategy() {
        return instanceStrategy;
    }

    public void setInstanceStrategy(InstanceStrategy instanceStrategy) {
        this.instanceStrategy = instanceStrategy;
    }
}