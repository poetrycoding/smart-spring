package com.github.poetrycoding.springframework.context.event;

import com.github.poetrycoding.springframework.context.ApplicationEvent;

/**
 * Description: 上下文容器刷新事件
 * <br/>
 * ContextRefreshedEvent
 *
 * @author laiql
 * @date 2023/5/5 21:43
 */
public class ContextRefreshedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
