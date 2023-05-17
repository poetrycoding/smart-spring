package com.github.poetrycoding.springframework.test.aop;

import com.github.poetrycoding.springframework.aop.AdvisedSupport;
import com.github.poetrycoding.springframework.aop.ClassFilter;
import com.github.poetrycoding.springframework.aop.TargetSource;
import com.github.poetrycoding.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.github.poetrycoding.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.github.poetrycoding.springframework.aop.framework.ProxyFactory;
import com.github.poetrycoding.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import com.github.poetrycoding.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.poetrycoding.springframework.test.aop.service.IAopTestService;
import com.github.poetrycoding.springframework.test.aop.service.impl.AopTestServiceImpl;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;

public class AopTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void init() {
        // 目标对象
        IAopTestService aopTestService = new AopTestServiceImpl();
        // 组装代理信息
        advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(aopTestService));
        advisedSupport.setMethodInterceptor(new AopServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.github.poetrycoding.springframework.test.aop.service.IAopTestService.*(..))"));
    }

    @Test
    public void testProxyFactory() {
        // false/true，JDK动态代理、CGlib动态代理
        advisedSupport.setProxyTargetClass(true);
        IAopTestService aopTestService = (IAopTestService) new ProxyFactory(advisedSupport).getProxy();
        System.out.println(aopTestService.aopTest());
        System.out.println(aopTestService.getClass());
    }

    @Test
    public void testAdvisor() {
        IAopTestService aopTestService = new AopTestServiceImpl();
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* com.github.poetrycoding.springframework.test.aop.service.IAopTestService.*(..))");
        advisor.setAdvice(new MethodBeforeAdviceInterceptor(new AopServiceBeforeAdvice()));
        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(aopTestService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();

            //创建代理目标对象
            TargetSource targetSource = new TargetSource(aopTestService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            //设置代理模式 true=Cglib代理模式， false=jdk代理模式
            advisedSupport.setProxyTargetClass(false);

            //从代理工厂获取代理对象
            IAopTestService proxy = (IAopTestService) new ProxyFactory(advisedSupport).getProxy();

            System.out.println(proxy.aopTest());
            System.out.println(proxy.getClass());
        }
    }

    @Test
    public void testAop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        IAopTestService aopTestService = applicationContext.getBean("aopTestService", IAopTestService.class);
        System.out.println("测试结果：" + aopTestService.aopReg());
        System.out.println(aopTestService.getClass());
    }
}
