package com.github.poetrycoding.springframework.factory;

/**
 * Description: BeanName感知接口
 * <br/>
 * BeanNameAware
 *
 * @author laiql
 * @date 2023/5/4 16:28
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
