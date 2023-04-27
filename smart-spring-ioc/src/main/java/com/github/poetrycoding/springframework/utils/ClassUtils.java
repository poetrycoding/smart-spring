package com.github.poetrycoding.springframework.utils;

import cn.hutool.core.util.ClassUtil;

/**
 * Description: 类操作工具类
 * <br/>
 * ClassUtils
 *
 * @author laiql
 * @date 2023/4/27 20:59
 */
public class ClassUtils {
    private ClassUtils() {
    }

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();

        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (classLoader == null) {
            // No thread context class loader -> use class loader of this class.
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
