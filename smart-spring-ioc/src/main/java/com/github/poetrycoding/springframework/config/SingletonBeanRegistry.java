package com.github.poetrycoding.springframework.config;

/**
 * Description: 单利bean注册表
 * <br/>
 * SingletonBeanRegistry
 *
 * @author laiql
 * @date 2023/4/26 10:04
 */
public interface SingletonBeanRegistry {
    /**
     * 根据名称获取单例Bean对象
     *
     * @param beanName 名称
     * @return 返回对象
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例Bean对象
     *
     * @param beanName        名称
     * @param singletonObject 单例Bean对象
     */
    void registerSingleton(String beanName, Object singletonObject);
}
