package com.github.poetrycoding.springframework.test;

import com.github.poetrycoding.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.poetrycoding.springframework.test.event.CustomEvent;
import org.junit.Test;

/**
 * Description: 事件测试
 * <br/>
 * ApiTest
 *
 * @author laiql
 * @date 2023/5/5 22:15
 */
public class ApiTest {

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}
