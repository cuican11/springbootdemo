package com.hwgif.common.annotation;


import java.lang.annotation.*;

/**
 * 自定义注解
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExampleAnnotation {
    public final String  DEFAULT_STRING="DEFAULT";
    String value() default DEFAULT_STRING;
}
