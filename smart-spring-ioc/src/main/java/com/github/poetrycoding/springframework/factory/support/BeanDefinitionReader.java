package com.github.poetrycoding.springframework.factory.support;

import com.github.poetrycoding.springframework.core.io.Resource;
import com.github.poetrycoding.springframework.core.io.ResourceLoader;
import com.github.poetrycoding.springframework.exception.BeansException;

/**
 * Description: BeanDefinition读取操作接口定义
 * <br/>
 * BeanDefinitionReader
 *
 * @author laiql
 * @date 2023/4/27 21:18
 */
public interface BeanDefinitionReader {

    /**
     * 获取BeanDefinitionRegistry注册器
     *
     * @return @see BeanDefinitionRegistry
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     *
     * @return ResourceLoader
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载Resource
     *
     * @param resource 加载资源
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载多个Resource
     *
     * @param resources 资源
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 根据路径加载资源
     *
     * @param location 路径
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 根据路径加载资源
     *
     * @param locations 路径
     * @throws BeansException
     */
    void loadBeanDefinitions(String... locations) throws BeansException;
}
