package com.hy.aspect.login.core;

import android.app.Application;
import android.content.Context;

/**
 * 登录管理类
 */
public class LoginManager {

    private static LoginManager instance;

    private Context applicationContext;

    private ILogin iLogin;

    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化LoginManager
     *
     * @param context Application
     * @param iLogin  登录操作实现
     */
    public void init(Application context, ILogin iLogin) {
        this.applicationContext = context;
        this.iLogin = iLogin;
    }

    public ILogin getILogin() {
        return iLogin;
    }

    public Context getContext() {
        return applicationContext;
    }

    /**
     * 设置登录失效（token过期等等情况导致）
     *
     * @param loginMode 登录模式
     */
    public void loginInvalid(int loginMode) {
        if (iLogin == null) {
            return;
        }
        iLogin.clearLoginStatus();
        iLogin.login(applicationContext, loginMode);
    }

}
