package fun.chaoxi.android.view.driver.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import fun.chaoxi.android.common.ConfigConstant;
import fun.chaoxi.android.common.util.ToastUtil;
import fun.chaoxi.android.view.home.HomeActivity;

/**
 * Create by Wing Gao on 2018/10/30 18:55
 */
public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View fragment;
    Context context;
    SharedPreferences sharedPreferences;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.fragment = loginView;
//        sharedPreferences = context.getSharedPreferences(ConfigConstant.UserInfo, Context.MODE_PRIVATE);
    }

    @Override
    public void login(String username, String password) {
        if (username == null || password == null) {
            ToastUtil.show("请输入有效的用户名和密码");
        } else if ("18510247730".equals(username) && "000000".equals(password)) {
            ToastUtil.show("登录成功");
            context.startActivity(new Intent(context, HomeActivity.class));
            fragment.finish();
        } else {
            ToastUtil.show("登陆失败");
        }
    }

    @Override
    public void subScribe() {

    }

    @Override
    public void unSubScribe() {

    }
}
