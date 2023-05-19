package com.github.poetrycoding.springframework.factory.annotation;

import java.lang.annotation.*;

/**
 * Description: 属性注入注解
 * * Annotation at the field or method/constructor parameter level
 * * that indicates a default value expression for the affected argument.
 * <br/>
 * Value
 *
 * @author laiql
 * @date 2023/5/19 14:29
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();

}