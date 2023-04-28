package com.github.poetrycoding.springframework.context.support;

import com.github.poetrycoding.springframework.context.ApplicationContext;
import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.support.DefaultListableBeanFactory;

/**
 * Description: 主要实现容器刷新和Bean创建相关
 * * Base class for {@link ApplicationContext}
 * * implementations which are supposed to support multiple calls to {@link #refresh()},
 * * creating a new internal bean factory instance every time.
 * * Typically (but not necessarily), such a context will be driven by
 * * a set of config locations to load bean definitions from.
 * <br/>
 * AbstractRefreshableApplicationContext
 *
 * @author laiql
 * @date 2023/4/28 21:35
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 加载外部资源配置并生成BeanDefinition对象注册到容器中
     *
     * @param beanFactory 上下文工厂
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);


    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
