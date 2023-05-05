package com.github.poetrycoding.springframework.context;

import java.util.EventListener;

/**
 * * Interface to be implemented by application event listeners.
 * * Based on the standard <code>java.util.EventListener</code> interface
 * * for the Observer design pattern.
 * Description: 监听事件接口定义
 * <br/>
 * ApplicationListener
 *
 * @author laiql
 * @date 2023/5/5 21:34
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {


    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
