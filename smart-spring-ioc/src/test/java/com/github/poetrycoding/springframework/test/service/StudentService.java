package com.github.poetrycoding.springframework.test.service;

import com.github.poetrycoding.springframework.factory.DisposableBean;
import com.github.poetrycoding.springframework.factory.InitializingBean;
import com.github.poetrycoding.springframework.test.dao.StudentDAO;

/**
 * Description: 测试Service
 * <br/>
 * StudentService
 *
 * @author laiql
 * @date 2023/4/26 10:40
 */
public class StudentService implements InitializingBean, DisposableBean {

    private String name;
    private StudentDAO studentDAO;

    public StudentService() {
    }

    public StudentService(String name) {
        this.name = name;
    }

    public StudentService(String name, StudentDAO studentDAO) {
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
        System.out.println("{" + studentDAO.queryById("10001") + "}--StudentService.study======> study spring ioc....[" + getName() + "]");
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
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
}
