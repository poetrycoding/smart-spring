package com.github.poetrycoding.springframework.factory.annotation;

import java.lang.annotation.*;

/**
 * Description:
 * * This annotation may be used on a field or parameter as a qualifier for
 * * candidate beans when autowiring. It may also be used to annotate other
 * * custom annotations that can then in turn be used as qualifiers.
 * <br/>
 * Qualifier
 *
 * @author laiql
 * @date 2023/5/19 14:30
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
