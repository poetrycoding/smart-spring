package com.github.poetrycoding.springframework.test.processor;


import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.config.BeanPostProcessor;
import com.github.poetrycoding.springframework.test.service.StudentService;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if ("studentService".equals(beanName)) {
//            StudentService studentService = (StudentService) bean;
//            studentService.setName("改为：6666加有");
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
