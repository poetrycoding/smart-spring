package com.github.poetrycoding.springframework.aop.framework;

import com.github.poetrycoding.springframework.aop.AdvisedSupport;

/**
 * Description: 代理工厂
 * <br/>
 * ProxyFactory
 *
 * @author laiql
 * @date 2023/5/16 22:16
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }
}
