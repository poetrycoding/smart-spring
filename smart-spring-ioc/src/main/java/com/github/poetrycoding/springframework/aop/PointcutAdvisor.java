package com.github.poetrycoding.springframework.aop;

/**
 * Description:
 * <br/>
 * PointcutAdvisor
 *
 * @author laiql
 * @date 2023/5/16 21:49
 */
public interface PointcutAdvisor extends Advisor {
    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();
}
