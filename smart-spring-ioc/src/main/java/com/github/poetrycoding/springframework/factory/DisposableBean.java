package com.github.poetrycoding.springframework.factory;

/**
 * Description:
 * * Interface to be implemented by beans that want to release resources
 * * on destruction. A BeanFactory is supposed to invoke the destroy
 * * method if it disposes a cached singleton. An application context
 * * is supposed to dispose all of its singletons on close.
 * <br/>
 * DisposableBean
 *
 * @author laiql
 * @date 2023/5/2 15:29
 */
public interface DisposableBean {
    /**
     * 执行容器销毁的时候执行
     *
     * @throws Exception
     */
    void destroy() throws Exception;
}
