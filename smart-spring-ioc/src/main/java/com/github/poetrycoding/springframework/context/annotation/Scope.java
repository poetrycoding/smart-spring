package com.github.poetrycoding.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * Description: scope注解
 * <br/>
 * Scope
 *
 * @author laiql
 * @date 2023/5/19 14:00
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";

}