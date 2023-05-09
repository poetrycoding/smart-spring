package com.github.poetrycoding.springframework.test.aop;

import com.github.poetrycoding.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.github.poetrycoding.springframework.test.aop.service.impl.AopTestServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BaseAopTest {

    @Test
    public void proxyMethod() {
        //创建目标对象
        Object targetObject = new AopTestServiceImpl();

        //Aop代理
        Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObject.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
    }

    @Test
    public void aopTest() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut =
                new AspectJExpressionPointcut("execution(* com.github.poetrycoding.springframework.test.aop.service.impl.AopTestServiceImpl.*(..))");
        Class<AopTestServiceImpl> serviceClass = AopTestServiceImpl.class;
        Method method = serviceClass.getDeclaredMethod("aopTest");

        System.out.println(pointcut.matches(serviceClass));
        System.out.println(pointcut.matches(method, serviceClass));
    }
}
