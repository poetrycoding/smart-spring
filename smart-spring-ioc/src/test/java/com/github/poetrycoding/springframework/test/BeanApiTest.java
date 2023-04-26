package com.github.poetrycoding.springframework.test;

import com.github.poetrycoding.springframework.config.BeanDefinition;
import com.github.poetrycoding.springframework.factory.DefaultListableBeanFactory;
import com.github.poetrycoding.springframework.test.service.StudentService;
import org.junit.Test;

/**
 * Description: Bean注册定义测试
 * <br/>
 * BeanApiTest
 *
 * @author laiql
 * @date 2023/4/26 10:43
 */
public class BeanApiTest {
    @Test
    public void testFactory() {
        //创建IOC容器工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建Bean定义信息
        BeanDefinition bd = new BeanDefinition(StudentService.class);
        //注册Bean
        beanFactory.registerBeanDefinition("studyService", bd);

        //从工厂获取Bean实例
        StudentService studentService1 = (StudentService) beanFactory.getBean("studyService");
        studentService1.study();
        System.out.println("studentService1.hashCode() = " + studentService1.hashCode());

        StudentService studentService2 = (StudentService) beanFactory.getBean("studyService");
        studentService2.study();
        System.out.println("studentService2.hashCode() = " + studentService2.hashCode());

    }
}
