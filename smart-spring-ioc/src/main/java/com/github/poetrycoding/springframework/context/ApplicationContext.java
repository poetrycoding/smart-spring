package com.github.poetrycoding.springframework.context;

import com.github.poetrycoding.springframework.factory.ListableBeanFactory;

/**
 * Description: 应用上下文
 * * Central interface to provide configuration for an application.
 * * This is read-only while the application is running, but may be
 * * reloaded if the implementation supports this.
 * <br/>
 * ApplicationContext
 *
 * @author laiql
 * @date 2023/4/28 21:21
 */
public interface ApplicationContext extends ListableBeanFactory {
}
