package com.github.poetrycoding.springframework.context;

/**
 * * Interface that encapsulates event publication functionality.
 * * Serves as super-interface for ApplicationContext.
 * <p>
 * Description: 事件发布者接口
 * <br/>
 * ApplicationEventPublisher
 *
 * @author laiql
 * @date 2023/5/5 21:36
 */
public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     *
     * @param applicationEvent the event to publish
     */
    void publishEvent(ApplicationEvent applicationEvent);
}
