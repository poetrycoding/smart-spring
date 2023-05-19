package com.github.poetrycoding.springframework.test;

import com.github.poetrycoding.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.poetrycoding.springframework.test.service.StudentService;
import org.junit.Test;

public class ScanTest {
    @Test
    public void scanTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.study();
        System.out.println(studentService.getClass());
    }
}
