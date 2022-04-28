# AspectLogin
AspectJ实现登录拦截功能

## 使用方式
1. 添加依赖
  ``` 
  implementation 'com.github.H-Yongzi:AspectLogin:1.0.0'
  ```
2. 初始化：
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
3. 登录校验：
```
    @LoginFilter
    fun createOrder() {
        // 执行需要登录后才能进行的操作
    }
 ```