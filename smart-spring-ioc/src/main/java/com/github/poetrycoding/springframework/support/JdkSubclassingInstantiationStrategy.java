package com.github.poetrycoding.springframework.support;

import com.github.poetrycoding.springframework.config.BeanDefinition;
import com.github.poetrycoding.springframework.exception.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * Description: jdk方式实例化对象
 * <br/>
 * JdkSubclassingInstantiationStrategy
 *
 * @author laiql
 * @date 2023/4/26 21:00
 */
public class JdkSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instance(String beanName, BeanDefinition bd, Constructor constructor, Object[] args) {
        Class beanClass = bd.getBeanClass();
        try {
            if (Objects.nonNull(constructor)) {
                //有参构造创建实例对象
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                //无参构造创建实例对象
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }

    }
}
