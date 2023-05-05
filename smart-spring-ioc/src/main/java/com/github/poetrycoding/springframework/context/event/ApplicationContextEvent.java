package com.github.poetrycoding.springframework.context.event;


import com.github.poetrycoding.springframework.context.ApplicationContext;
import com.github.poetrycoding.springframework.context.ApplicationEvent;

/**
 * Base class for events raised for an <code>ApplicationContext</code>.
 * <br/>
 * ApplicationContextEvent
 *
 * @author laiql
 * @date 2023/5/5 22:14
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
