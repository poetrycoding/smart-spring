package com.github.poetrycoding.springframework.aop.framework;

import com.github.poetrycoding.springframework.aop.AdvisedSupport;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Description: Cglib动态代理实现
 * <br/>
 * Cglib2AopProxy
 *
 * @author laiql
 * @date 2023/5/9 10:38
 */
public class Cglib2AopProxy implements AopProxy {

    private final AdvisedSupport advisedSupport;

    public Cglib2AopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        //设置父类Class
        enhancer.setSuperclass(advisedSupport.getTargetSource().getTarget().getClass());
        //设置父类接口
        enhancer.setInterfaces(advisedSupport.getTargetSource().getTargetClass());
//        enhancer.setCallback();
        return enhancer;
    }

    private static class DynamicAdvisedInterceptor implements MethodInterceptor {
        private final AdvisedSupport advisedSupport;

        private DynamicAdvisedInterceptor(AdvisedSupport advisedSupport) {
            this.advisedSupport = advisedSupport;
        }

        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            return null;
        }
    }

    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {

        private final MethodProxy methodProxy;

        public CglibMethodInvocation(Object target, Method method, Object[] arguments, MethodProxy methodProxy) {
            super(target, method, arguments);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target, this.arguments);
        }
    }
}
