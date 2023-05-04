package com.github.poetrycoding.springframework.factory;

/**
 * Description: Bean 类加载器感知接口
 * <br/>
 * BeanClassLoaderAware
 *
 * @author laiql
 * @date 2023/5/4 16:26
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);
}
