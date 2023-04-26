package com.github.poetrycoding.springframework.exception;

/**
 * Description: Bean异常类定义
 * <br/>
 * BeanException
 *
 * @author laiql
 * @date 2023/4/26 10:00
 */
public class BeansException extends RuntimeException {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
