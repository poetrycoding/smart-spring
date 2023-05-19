package com.github.poetrycoding.springframework.utils;

import com.github.poetrycoding.springframework.factory.config.ConfigurableBeanFactory;

/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link ConfigurableBeanFactory}.
 * <p>
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public interface StringValueResolver {

    /**
     * 解析Value注解
     * @param strVal
     * @return
     */
    String resolveStringValue(String strVal);

}
