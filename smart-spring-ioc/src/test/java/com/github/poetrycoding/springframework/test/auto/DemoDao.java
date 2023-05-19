package com.github.poetrycoding.springframework.test.auto;

import com.github.poetrycoding.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DemoDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "广东，深圳，南山");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
