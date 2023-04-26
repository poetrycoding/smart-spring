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
    private static Map<String, String> data = new HashMap<>();

    static {
        data.put("10001", "jack");
        data.put("10002", "danny");
    }

    public String queryById(String id) {
        return data.get(id);
    }
}
