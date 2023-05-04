package com.github.poetrycoding.springframework.test;

import com.github.poetrycoding.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.poetrycoding.springframework.test.service.StudentService;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * Description: 工厂Bean测试工具
 * <br/>
 * FactoryApiTest
 *
 * @author laiql
 * @date 2023/5/4 22:48
 */
public class FactoryApiTest {

    @Test
    public void testPrototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        StudentService studentService01 = applicationContext.getBean("studentService", StudentService.class);
        StudentService studentService02 = applicationContext.getBean("studentService", StudentService.class);
        System.out.println("studentService01 = " + studentService01);
        System.out.println("studentService02 = " + studentService02);

        // 4. 打印十六进制哈希
        System.out.println(studentService01 + " 十六进制哈希：" + Integer.toHexString(studentService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(studentService01).toPrintable());

    }

    @Test
    public void testFactoryBean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.study();
    }
}
