package com.github.poetrycoding.springframework.aop.framework.adapter;

import com.github.poetrycoding.springframework.aop.MethodBeforeAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Description: 方法前置拦截器
 * * Interceptor to wrap am {@link MethodBeforeAdvice}.
 * * Used internally by the AOP framework; application developers should not need
 * * to use this class directly.
 * <br/>
 * MethodBeforeAdviceInterceptor
 *
 * @author laiql
 * @date 2023/5/16 22:00
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice methodBeforeAdvice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice methodBeforeAdvice) {
        this.methodBeforeAdvice = methodBeforeAdvice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.methodBeforeAdvice.before(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
