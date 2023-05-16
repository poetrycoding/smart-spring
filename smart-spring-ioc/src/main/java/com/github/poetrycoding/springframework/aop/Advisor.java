package com.github.poetrycoding.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * Description: 抽象访问者
 * * Base interface holding AOP <b>advice</b> (action to take at a joinpoint)
 * * and a filter determining the applicability of the advice (such as
 * * a pointcut). <i>This interface is not for use by Spring users, but to
 * * allow for commonality in support for different types of advice.</i>
 * <br/>
 * Advisor
 *
 * @author laiql
 * @date 2023/5/16 21:45
 */
public interface Advisor {


    /**
     * 拦截器链
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     *
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
