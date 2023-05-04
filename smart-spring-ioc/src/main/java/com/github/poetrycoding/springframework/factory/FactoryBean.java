package com.github.poetrycoding.springframework.factory;

/**
 * Description: 创建Bean的工厂
 * <br/>
 * FactoryBean
 *
 * @author laiql
 * @date 2023/5/4 22:22
 */
public interface FactoryBean<T> {

    /**
     * 获取Bean对象
     *
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 获取Bean的类型
     *
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否单例Bean对象
     *
     * @return
     */
    boolean isSingleton();
}
