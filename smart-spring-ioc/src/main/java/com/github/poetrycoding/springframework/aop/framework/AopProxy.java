package com.github.poetrycoding.springframework.aop.framework;

/**
 * Description: Aop代理对象接口
 * * Delegate interface for a configured AOP proxy, allowing for the creation
 * * of actual proxy objects.
 * *
 * * <p>Out-of-the-box implementations are available for JDK dynamic proxies
 * * and for CGLIB proxies, as applied by DefaultAopProxyFactory
 * <br/>
 * AopProxy
 *
 * @author laiql
 * @date 2023/5/9 10:31
 */
public interface AopProxy {

    /**
     * 获取代理对象
     *
     * @return 返回代理对象
     */
    Object getProxy();
}
