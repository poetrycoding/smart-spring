package com.github.poetrycoding.springframework.factory;

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
public interface ListableBeanFactory {
}
