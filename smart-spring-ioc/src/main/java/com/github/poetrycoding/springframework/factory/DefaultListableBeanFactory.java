package com.github.poetrycoding.springframework.factory;

import com.github.poetrycoding.springframework.config.BeanDefinition;
import com.github.poetrycoding.springframework.config.BeanDefinitionRegistry;
import com.github.poetrycoding.springframework.exception.BeanDefinitionStoreException;
import com.github.poetrycoding.springframework.exception.BeansException;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: Spring核心容器实现
 * <br/>
 * DefaultListableBeanFactory
 *
 * @author laiql
 * @date 2023/4/26 10:29
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    /**
     * Bean定义对象的映射，以Bean名称为键  IoC容器
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition bd = this.beanDefinitionMap.get(beanName);
        if (Objects.isNull(bd)) {
            throw new BeansException("No bean named '" + beanName + "' not found ");
        }
        return bd;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException {
        //因为beanDefinitionMap是全局变量，这里定会存在并发访问的情况
        synchronized (this.beanDefinitionMap) {
            this.beanDefinitionMap.put(beanName, beanDefinition);
        }
    }
}
