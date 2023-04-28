package com.github.poetrycoding.springframework.factory;

import com.github.poetrycoding.springframework.exception.BeansException;

import java.util.Map;

/**
 * Description:
 * * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * * that can enumerate all their bean instances, rather than attempting bean lookup
 * * by name one by one as requested by clients. BeanFactory implementations that
 * * preload all their bean definitions (such as XML-based factories) may implement
 * * this interface.
 * <br/>
 * ListableBeanFactory
 *
 * @author laiql
 * @date 2023/4/27 21:35
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
