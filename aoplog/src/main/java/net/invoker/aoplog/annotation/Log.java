package net.invoker.aoplog.annotation;

/**
 * @Author: invoker
 * @Date: 2020/8/8 上午11:45
 * @Description：自定义日志拦截注解
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用@interface将定义一个注解 这里是log
 * 用于日志aop编程
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
