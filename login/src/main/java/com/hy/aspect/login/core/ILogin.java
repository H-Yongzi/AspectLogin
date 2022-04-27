package com.hy.aspect.login.core;

import android.content.Context;

/**
 * 登录相关操作
 */
public interface ILogin {

    /**
     * 执行登录操作
     *
     * @param context          用于页面跳转等
     * @param loginExecuteMode 登录执行方式(默认为0，跳转到登录页面)
     */
    void login(Context context, int loginExecuteMode);

    /**
     * 是否已登录
     */
    boolean isLoggedIn();

    /**
     * 清空登录状态
     */
    void clearLoginStatus();

}
