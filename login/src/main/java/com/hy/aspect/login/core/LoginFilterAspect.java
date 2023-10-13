package com.hy.aspect.login.core;

import android.content.Context;
import android.util.Log;

import com.hy.aspect.login.annotation.LoginFilter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 登录拦截
 * Date: 2022-4-27
 * Company: 铸远集团
 * Author: huangyong
 */
@Aspect
public class LoginFilterAspect {

    /**
     * 切入点为所有被LoginFilter注释的方法（第一个*表示返回类型为任意，第二个*表示方法名为任意，..表示方法入参任意）
     * Date: 2022-4-27 17:36
     * Author: huangyong
     */
    @Pointcut("execution(@com.hy.aspect.login.annotation.LoginFilter * *(..))")
    public void loginFilter() {
    }

    @Around("loginFilter()")
    public void aroundLoginFilter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object = joinPoint.getThis();
        if (object == null) {
            return;
        }
        ILogin iLogin = LoginManager.getInstance().getILogin();
        if (iLogin == null) {
            throw new IllegalAccessException("LoginManager没有初始化！");
        }

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalAccessException("LoginFilter只能用于注释方法！");
        }

        MethodSignature methodSignature = (MethodSignature) signature;
        LoginFilter loginFilter = methodSignature.getMethod().getAnnotation(LoginFilter.class);
        if (loginFilter == null) {
            return;
        }

        Context context = LoginManager.getInstance().getContext();
        // isLoggedIn的判断逻辑在初始化时传入的接口实现类中自定义
        if (iLogin.isLoggedIn()) {
            try {
                joinPoint.proceed();
            } catch (Exception e) {
                Log.e("LoginFilterAspect", "aroundLoginPoint(LoginFilterAspect.java:42)-->>" + e.getLocalizedMessage());
            }
        } else {
            iLogin.login(context, loginFilter.loginMode());
        }

    }
}
