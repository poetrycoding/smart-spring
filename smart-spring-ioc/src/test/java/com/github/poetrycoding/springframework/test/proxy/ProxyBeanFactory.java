package com.github.poetrycoding.springframework.test.proxy;


import com.github.poetrycoding.springframework.factory.FactoryBean;
import com.github.poetrycoding.springframework.test.dao.IStudentDAO;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyBeanFactory implements FactoryBean<IStudentDAO> {

    @Override
    public IStudentDAO getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            // 添加排除方法
            if ("toString".equals(method.getName())) return this.toString();

            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "jack");
            hashMap.put("10002", "danny");
            hashMap.put("10003", "andy");

            return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
        };
        return (IStudentDAO) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IStudentDAO.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IStudentDAO.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
