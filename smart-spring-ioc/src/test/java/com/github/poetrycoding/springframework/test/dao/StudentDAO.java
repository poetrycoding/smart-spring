package com.github.poetrycoding.springframework.test.dao;

import com.github.poetrycoding.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: StudentDAO
 * <br/>
 * StudentDAO
 *
 * @author laiql
 * @date 2023/4/26 22:58
 */
@Component(value = "studentDAO")
public class StudentDAO implements IStudentDAO{
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "jack");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }
    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "jack");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    @Override
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
