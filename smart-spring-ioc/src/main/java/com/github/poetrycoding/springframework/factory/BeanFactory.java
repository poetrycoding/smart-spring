package com.github.poetrycoding.springframework.factory;

import com.github.poetrycoding.springframework.exception.BeansException;

/**
 * Description: Bean工厂顶层接口定义
 * <br/>
 * BeanFactory
 *
 * @author laiql
 * @date 2023/4/26 09:58
 */
public interface BeanFactory {

    /**
     * 通过Bean名称获取对象
     *
     * @param beanName bean名称
     * @return
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 根据名称和参数获取实例对象
     *
     * @param beanName 名称
     * @param args     参数
     * @return 返回bean实例
     * @throws BeansException
     */
    Object getBean(String beanName, Object... args) throws BeansException;
}
