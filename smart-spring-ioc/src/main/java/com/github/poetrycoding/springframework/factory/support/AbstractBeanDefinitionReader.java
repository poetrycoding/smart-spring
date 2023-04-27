package com.github.poetrycoding.springframework.factory.support;

import com.github.poetrycoding.springframework.core.io.DefaultResourceLoader;
import com.github.poetrycoding.springframework.core.io.Resource;
import com.github.poetrycoding.springframework.core.io.ResourceLoader;

/**
 * Description: 核心XML资源加载实现
 * <br/>
 * AbstractBeanDefinitionReader
 *
 * @author laiql
 * @date 2023/4/27 21:22
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    private final ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        //默认从Classpath加载
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
