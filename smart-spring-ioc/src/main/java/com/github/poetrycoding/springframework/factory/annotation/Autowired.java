package com.github.poetrycoding.springframework.factory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 依赖注入注解
 * * Marks a constructor, field, setter method or config method as to be
 * * autowired by Spring's dependency injection facilities.
 * <br/>
 * Autowired
 *
 * @author laiql
 * @date 2023/5/19 14:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
public @interface Autowired {
}
