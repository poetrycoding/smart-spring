package com.github.poetrycoding.springframework.context.event;

import com.github.poetrycoding.springframework.context.ApplicationEvent;
import com.github.poetrycoding.springframework.context.ApplicationListener;
import com.github.poetrycoding.springframework.factory.BeanFactory;

/**
 * Simple implementation of the {@link ApplicationEventMulticaster} interface.
 * <br/>
 * SimpleApplicationEventMulticaster
 *
 * @author laiql
 * @date 2023/5/5 22:09
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }

}
