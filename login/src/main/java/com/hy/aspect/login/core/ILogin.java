package com.hy.aspect.login.core;

import android.content.Context;

/**
 * 登录相关操作
 * Date: 2022-4-27
 * Company: 铸远集团
 * Author: huangyong
 */
public interface ILogin {

    /**
     * 执行登录操作
     * Date: 2022-4-27 17:33
     * Author: huangyong
     *
     * @param context   用于页面跳转等
     * @param loginMode 登录执行方式(默认为0，跳转到登录页面)
     */
    void login(Context context, int loginMode);

    /**
     * 是否已登录
     * Date: 2022-4-27 17:33
     * Author: huangyong
     *
     * @return boolean
     */
    boolean isLoggedIn();

    /**
     * 清空登录状态
     * Date: 2022-4-27 17:33
     * Author: huangyong
     */
    void clearLoginStatus();

}
