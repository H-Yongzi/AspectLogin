package com.hy.aspect

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.hy.aspect.login.annotation.LoginFilter
import com.hy.aspect.login.core.ILogin
import com.hy.aspect.login.core.LoginManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLogin()

        findViewById<Button>(R.id.no_login).setOnClickListener {
            noLogin()
        }
        findViewById<Button>(R.id.has_login).setOnClickListener {
            hasLogin()
        }
        findViewById<Button>(R.id.token_invalid).setOnClickListener {
            tokenInvalid()
        }
    }

    private fun initLogin() {
        LoginManager.getInstance().init(application, object : ILogin {
            override fun login(context: Context, loginMode: Int) {
                // 根据loginMode执行对应的操作
                if (loginMode == 0) {
                    // 跳转到登录页面
                } else {
                    // 跳转其他页面
                }
            }

            override fun isLoggedIn(): Boolean {
                // 判断当前是否登录，判断逻辑根据项目需求自定义
                return false
            }

            override fun clearLoginStatus() {
                // 清空登录信息，比如token、缓存的登录信息等等
            }
        })
    }

    @LoginFilter
    fun noLogin() {
        Toast.makeText(this, "noLogin", Toast.LENGTH_LONG).show()
    }

    @LoginFilter
    fun hasLogin() {
        Toast.makeText(this, "hasLogin", Toast.LENGTH_LONG).show()
    }

    private fun tokenInvalid() {
        LoginManager.getInstance().loginInvalid(0)
    }

}