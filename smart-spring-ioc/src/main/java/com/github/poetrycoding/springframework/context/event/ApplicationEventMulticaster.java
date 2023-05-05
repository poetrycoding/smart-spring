package com.github.poetrycoding.springframework.context.event;

import com.github.poetrycoding.springframework.context.ApplicationEvent;
import com.github.poetrycoding.springframework.context.ApplicationListener;

/**
 * Description: 事件广播器接口定义
 * <br/>
 * ApplicationEventMulticaster
 *
 * @author laiql
 * @date 2023/5/5 21:43
 */
public interface ApplicationEventMulticaster {

    /**
     * Add a listener to be notified of all events.
     *
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     *
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     *
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
