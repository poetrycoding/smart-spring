package com.github.poetrycoding.springframework.test.aop.service.impl;

import com.github.poetrycoding.springframework.test.aop.service.IAopTestService;

public class AopTestServiceImpl implements IAopTestService {
    @Override
    public String aopTest() {
        return "hello aop Test";
    }

    @Override
    public String aopReg() {
        return "Hello Aop Reg";
    }
}
