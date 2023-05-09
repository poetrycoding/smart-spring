package com.github.poetrycoding.springframework.aop;

/**
 * Description: 匹配类，用于切点找到给定的接口和目标类
 * <br/>
 * ClassFilter
 *
 * @author laiql
 * @date 2023/5/9 10:10
 */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);
}
