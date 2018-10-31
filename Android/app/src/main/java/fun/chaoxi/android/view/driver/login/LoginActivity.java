package fun.chaoxi.android.view.driver.login;

import android.support.v4.app.Fragment;

import fun.chaoxi.android.R;
import fun.chaoxi.android.common.base.BaseActivity;
import fun.chaoxi.android.common.util.ActivityManager;


/**
 * Create by Wing Gao on 2018/10/30 18:53
 */
public class LoginActivity extends BaseActivity {

    LoginPresenter loginPresenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        LoginView loginView = (LoginView) getSupportFragmentManager().findFragmentById(R.id.login_content_fl);
        if (loginView == null) {
            loginView = new LoginView();
            ActivityManager.addFragmentToActivity(getSupportFragmentManager(), loginView, R.id.login_content_fl);
        }
        loginPresenter = new LoginPresenter(this, loginView);
        loginView.setPresenter(loginPresenter);
    }
}
