package com.github.poetrycoding.springframework.test.aop;

import com.github.poetrycoding.springframework.aop.AdvisedSupport;
import com.github.poetrycoding.springframework.aop.MethodMatcher;
import com.github.poetrycoding.springframework.aop.TargetSource;
import com.github.poetrycoding.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.github.poetrycoding.springframework.aop.framework.Cglib2AopProxy;
import com.github.poetrycoding.springframework.aop.framework.JdkDynamicAopProxy;
import com.github.poetrycoding.springframework.aop.framework.ReflectiveMethodInvocation;
import com.github.poetrycoding.springframework.test.aop.service.IAopTestService;
import com.github.poetrycoding.springframework.test.aop.service.impl.AopTestServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
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
        IAopTestService aopTestService = (IAopTestService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObject.getClass().getInterfaces(), new InvocationHandler() {

            //方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* com.github.poetrycoding.springframework.test.aop.service.IAopTestService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObject.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - AOP");
                            System.out.println("方法名称：" + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    //反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObject, method, args));
                }
                return method.invoke(targetObject, args);
            }
        });
        System.out.println(aopTestService.aopTest());
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

    @Test
    public void testDynamic() {
        IAopTestService aopTestService = new AopTestServiceImpl();

        //组装代理对象
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(aopTestService));
        advisedSupport.setMethodInterceptor(new AopServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.github.poetrycoding.springframework.test.aop.service.IAopTestService.*(..))"));

        //使用jdk代理
        IAopTestService aopTestServiceJdk = (IAopTestService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println(aopTestServiceJdk.aopTest());
        System.out.println(aopTestServiceJdk.getClass());

        //使用cglib代理
        IAopTestService aopTestServiceCglib = (IAopTestService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println(aopTestServiceCglib.aopReg());
        System.out.println(aopTestServiceCglib.getClass());
    }
}
