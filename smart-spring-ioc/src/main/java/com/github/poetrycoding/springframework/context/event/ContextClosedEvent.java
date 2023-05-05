package com.github.poetrycoding.springframework.context.event;

import com.github.poetrycoding.springframework.context.ApplicationEvent;

/**
 * Description: 上下文容器关闭事件
 * <br/>
 * ContextClosedEvent
 *
 * @author laiql
 * @date 2023/5/5 21:40
 */
public class ContextClosedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
