package com.github.poetrycoding.springframework.test.dao;

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
public class StudentDAO {
    private static Map<String, String> hashMap = new HashMap<>();

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

    public String queryById(String id) {
        return hashMap.get(id);
    }
}
