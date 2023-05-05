package com.github.poetrycoding.springframework.context;

import com.github.poetrycoding.springframework.context.ApplicationContext;
import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.Aware;

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
