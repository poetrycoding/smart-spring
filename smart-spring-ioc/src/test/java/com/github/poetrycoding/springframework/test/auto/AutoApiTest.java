package com.github.poetrycoding.springframework.test.auto;

import com.github.poetrycoding.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class AutoApiTest {

    @Test
    public void autoTest() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-auto-scan.xml");

        IDemoService demoService = classPathXmlApplicationContext.getBean("demoService", IDemoService.class);
        demoService.demoMethod();
    }
}
