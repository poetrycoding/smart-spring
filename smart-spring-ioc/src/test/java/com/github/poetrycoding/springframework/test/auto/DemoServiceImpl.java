package com.github.poetrycoding.springframework.test.auto;

import com.github.poetrycoding.springframework.factory.annotation.Autowired;
import com.github.poetrycoding.springframework.factory.annotation.Value;
import com.github.poetrycoding.springframework.stereotype.Component;

@Component("demoService")
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private DemoDao demoDao;

    @Value("${system.name}")
    private String name;


    @Override
    public void demoMethod() {
        System.out.println(demoDao.getClass());
        System.out.println(name + "\t" + demoDao.queryUserName("10001"));
    }

    public DemoDao getDemoDao() {
        return demoDao;
    }

    public void setDemoDao(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
