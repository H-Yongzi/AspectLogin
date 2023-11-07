# AspectLogin

AspectJ实现登录拦截功能

## 使用方式

1. 在项目根目录build.gradle中添加配置

```
dependencies {
    classpath "com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.10"
}
```

2. 需要校验登录的module中的build.gradle中添加配置

``` 
plugins {
    id 'android-aspectjx'
}

aspectjx {
    // 需要校验权限的代码包名
    include 'com.xx.xx'
    enabled true
}

dependencies {
    implementation 'com.github.H-Yongzi:AspectLogin:1.0.0'
}
``` 

3. 初始化：

 ```
   LoginManager.getInstance().init(application, new ILogin() {
        @Override
        public void login(Context context, int loginMode) {
            // 根据loginMode执行对应的操作
            if (loginMode == 0) {
                // 跳转到登录页面
            } else {
                // 跳转其他页面
            }
        }
        @Override 
        public boolean isLoggedIn() {
            // 判断当前是否登录，判断逻辑根据项目需求自定义
            return false;
        }
        @Override 
        public void clearLoginStatus() {
            // 清空登录信息，比如token、缓存的登录信息等等
        }
    });
```

4. 登录校验：

```
    @LoginFilter
    fun createOrder() {
        // 执行需要登录后才能进行的操作
    }
 ```