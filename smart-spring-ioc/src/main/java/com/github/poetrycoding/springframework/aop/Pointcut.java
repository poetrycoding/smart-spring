package com.github.poetrycoding.springframework.aop;

/**
 * Description: 切点表达式接口
 * <br/>
 * Pointcut
 *
 * @author laiql
 * @date 2023/5/9 10:09
 */
public interface Pointcut {
    /**
     * Return the ClassFilter for this pointcut.
     *
     * @return the ClassFilter (never <code>null</code>)
     */
    ClassFilter getClassFilter();

    /**
     * Return the MethodMatcher for this pointcut.
     *
     * @return the MethodMatcher (never <code>null</code>)
     */
    MethodMatcher getMethodMatcher();
}
