package com.github.poetrycoding.springframework.aop;

import java.lang.reflect.Method;

/**
 * Description: 方法匹配，通过表达式找对定义的目标类下的方法
 * <br/>
 * MethodMatcher
 *
 * @author laiql
 * @date 2023/5/9 10:11
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     *
     * @return whether this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
