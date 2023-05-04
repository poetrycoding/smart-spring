package com.github.poetrycoding.springframework.factory;

import com.github.poetrycoding.springframework.context.ApplicationContext;
import com.github.poetrycoding.springframework.exception.BeansException;

/**
 * Description: 应用程序上下文感知接口
 * <br/>
 * ApplicationContextAware
 *
 * @author laiql
 * @date 2023/5/4 16:29
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
