package com.hy.aspect.login.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录状态过滤
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginFilter {
    /**
     * 定义登录执行方式 0 默认跳转登录页
     */
    int loginMode() default 0;
}
