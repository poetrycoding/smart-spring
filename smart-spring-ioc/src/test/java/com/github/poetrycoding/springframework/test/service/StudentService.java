package com.github.poetrycoding.springframework.test.service;

import com.github.poetrycoding.springframework.context.ApplicationContext;
import com.github.poetrycoding.springframework.context.ApplicationContextAware;
import com.github.poetrycoding.springframework.exception.BeansException;
import com.github.poetrycoding.springframework.factory.*;
import com.github.poetrycoding.springframework.test.dao.IStudentDAO;

/**
 * Description: 测试Service
 * <br/>
 * StudentService
 *
 * @author laiql
 * @date 2023/4/26 10:40
 */
public class StudentService implements InitializingBean, DisposableBean, ApplicationContextAware, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;


    private String name;
    private IStudentDAO studentDAO;

    public StudentService() {
    }

    public StudentService(String name) {
        this.name = name;
    }

    public StudentService(String name, IStudentDAO studentDAO) {
        this.name = name;
        this.studentDAO = studentDAO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 测试方法
     */
    public void study() {
        System.out.println("{" + studentDAO.queryUserName("10001") + "}--StudentService.study======> study spring ioc....[" + getName() + "]");
    }

    public IStudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("StudentService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("StudentService.afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("context = " + applicationContext);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("classLoader = " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("beanFactory = " + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("name = " + name);
    }
}
