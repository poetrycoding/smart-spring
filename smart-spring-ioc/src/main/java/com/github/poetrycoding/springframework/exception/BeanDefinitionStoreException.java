package com.github.poetrycoding.springframework.exception;

/**
 * Description: BeanDefinition CRUD 异常定义
 * <br/>
 * BeanDefinitionStoreException
 *
 * @author laiql
 * @date 2023/4/26 10:33
 */
public class BeanDefinitionStoreException extends RuntimeException {
    public BeanDefinitionStoreException() {
    }

    public BeanDefinitionStoreException(String message) {
        super(message);
    }
}
