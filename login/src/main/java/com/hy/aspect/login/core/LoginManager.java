package com.hy.aspect.login.core;

import android.app.Application;
import android.content.Context;

/**
 * 登录管理类
 * Date: 2022-4-27
 * Company: 铸远集团
 * Author: huangyong
 */
public class LoginManager {

    private static volatile LoginManager instance;

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
     * Date: 2022-4-27 18:38
     * Author: huangyong
     *
     * @param context Application
     * @param iLogin  登录操作实现
     */
    public void init(Application context, ILogin iLogin) {
        this.applicationContext = context;
        this.iLogin = iLogin;
    }

    /**
     * 获取ILogin实现实例
     * Date: 2022-4-27 18:50
     * Author: huangyong
     *
     * @return ILogin
     */
    public ILogin getILogin() {
        return iLogin;
    }

    /**
     * 获取applicationContext
     * Date: 2022-4-27 18:50
     * Author: huangyong
     */
    public Context getContext() {
        return applicationContext;
    }

    /**
     * 设置登录失效（token过期等等情况导致）
     * Date: 2022-4-27 18:50
     * Author: huangyong
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
