package com.github.poetrycoding.springframework.test.bean;


import com.github.poetrycoding.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_autoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-proxy-bean.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
