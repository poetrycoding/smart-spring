package com.github.poetrycoding.springframework.test;

import com.github.poetrycoding.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.poetrycoding.springframework.test.service.StudentService;
import org.junit.Test;

public class PropertiesTest {

    @Test
    public void propertiesTest(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");

        StudentService studentService = classPathXmlApplicationContext.getBean("studentService", StudentService.class);
        studentService.study();
        System.out.println(studentService.getClass());
    }
}
