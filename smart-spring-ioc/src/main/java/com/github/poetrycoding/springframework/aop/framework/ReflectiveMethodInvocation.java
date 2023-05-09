package com.github.poetrycoding.springframework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * Description: 入参包装调用
 * * <p>Invokes the target object using reflection. Subclasses can override the
 * * #invokeJoinpoint() method to change this behavior, so this is also
 * * a useful base class for more specialized MethodInvocation implementations.
 * <br/>
 * ReflectiveMethodInvocation
 *
 * @author laiql
 * @date 2023/5/9 10:44
 */
public class ReflectiveMethodInvocation implements MethodInvocation {
    /**
     * 目标对象
     */
    protected final Object target;
    /**
     * 方法
     */
    protected final Method method;
    /**
     * 入参
     */
    protected final Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return this.method.invoke(this.target, this.arguments);
    }

    @Override
    public Object getThis() {
        return this.target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return this.method;
    }
}
