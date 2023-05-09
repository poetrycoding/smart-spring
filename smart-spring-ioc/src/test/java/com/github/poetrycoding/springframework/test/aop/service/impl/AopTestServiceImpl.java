package com.github.poetrycoding.springframework.test.aop.service.impl;

import com.github.poetrycoding.springframework.test.aop.service.IAopTestService;

public class AopTestServiceImpl implements IAopTestService {
    @Override
    public void aopTest() {
        System.out.println("AopTestServiceImpl.aopTest");
    }
}
