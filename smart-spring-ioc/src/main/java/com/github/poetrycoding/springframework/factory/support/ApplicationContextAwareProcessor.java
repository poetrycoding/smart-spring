package com.github.poetrycoding.springframework.factory.support;

import com.github.poetrycoding.springframework.context.ApplicationContext;
import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.context.ApplicationContextAware;
import com.github.poetrycoding.springframework.factory.config.BeanPostProcessor;

/**
 * Description: 包装ApplicationContext 处理器
 * <br/>
 * ApplicationContextAwareProcessor
 *
 * @author laiql
 * @date 2023/5/4 16:31
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext context) {
        applicationContext = context;
    }

    /*
        由于在Bean创建的时候并不能直接获取ApplicationContext，所以需要在refresh时候吧ApplicationContext写入到包装处理器（ApplicationContextAwareProcessor）
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
