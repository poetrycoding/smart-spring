package com.github.poetrycoding.springframework.aop.aspectj;

import com.github.poetrycoding.springframework.aop.Pointcut;
import com.github.poetrycoding.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * Description: Spring AOP Advisor that can be used for any AspectJ pointcut expression.
 * <br/>
 * AspectJExpressionPointcutAdvisor
 *
 * @author laiql
 * @date 2023/5/16 21:57
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;

    /**
     * 具体的拦截方法
     */
    private Advice advice;

    /**
     * 表达式
     */
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
