package com.github.poetrycoding.springframework.context;

import com.github.poetrycoding.springframework.exception.BeansException;

/**
 * * SPI interface to be implemented by most if not all application contexts.
 * * Provides facilities to configure an application context in addition
 * * to the application context client methods in the
 * Description: 配置上下文
 * <br/>
 * ConfigurableApplicationContext
 *
 * @author laiql
 * @date 2023/4/28 21:21
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册钩子函数
     */
    void registerShutdownHook();

    /**
     * 关闭容器方法
     */
    void close();
}
