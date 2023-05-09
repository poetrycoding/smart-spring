package com.github.poetrycoding.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Description: 包装切面通知信息
 * * Base class for AOP proxy configuration managers.
 * * These are not themselves AOP proxies, but subclasses of this class are
 * * normally factories from which AOP proxy instances are obtained directly.
 * <br/>
 * AdvisedSupport
 *
 * @author laiql
 * @date 2023/5/9 10:20
 */
public class AdvisedSupport {
    /**
     * 被代理的目标对象
     */
    private TargetSource targetSource;

    /**
     * 方法拦截器
     */
    private MethodInterceptor methodInterceptor;

    /**
     * 方法匹配器
     */
    private MethodMatcher methodMatcher;


    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
