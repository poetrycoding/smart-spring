package com.github.poetrycoding.springframework.test.aop;

import com.github.poetrycoding.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AopServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
