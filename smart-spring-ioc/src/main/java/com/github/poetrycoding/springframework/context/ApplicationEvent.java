package com.github.poetrycoding.springframework.context;

import java.util.EventObject;

/**
 * * Class to be extended by all application events. Abstract as it
 * * doesn't make sense for generic events to be published directly.
 * Description: 抽象事件对象定义
 * <br/>
 * ApplicationEvent
 *
 * @author laiql
 * @date 2023/5/5 21:32
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
