package com.github.poetrycoding.springframework.test.service;

/**
 * Description: 测试Service
 * <br/>
 * StudentService
 *
 * @author laiql
 * @date 2023/4/26 10:40
 */
public class StudentService {

    private String name;

    public StudentService() {
    }

    public StudentService(String name) {
        this.name = name;
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
        System.out.println(getName() + "--StudentService.study======> study spring ioc....");
    }
}
