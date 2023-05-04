package com.github.poetrycoding.springframework.test.proxy;

import com.github.poetrycoding.springframework.factory.FactoryBean;
import com.github.poetrycoding.springframework.test.service.StudentService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyStudentBeanFactory implements FactoryBean<StudentService> {
    @Override
    public StudentService getObject() {
        InvocationHandler handler = (proxy, method, args) -> {
            // 添加排除方法
            if ("toString".equals(method.getName())) return this.toString();
            return "你被代理了 " + method.getName();
        };
        return (StudentService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{StudentService.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return StudentService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
