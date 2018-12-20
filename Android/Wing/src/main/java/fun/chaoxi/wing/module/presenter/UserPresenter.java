package fun.chaoxi.wing.module.presenter;

import androidx.annotation.NonNull;
import fun.chaoxi.wing.module.UserContract;

/**
 * @author Wing Gao
 * @date 2018/12/17 17:36
 * @description
 */
public class UserPresenter implements UserContract.Presenter {

    private UserContract.View userView;

    public UserPresenter(@NonNull UserContract.View userView) {
        this.userView = userView;
        userView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    /**
     * 用户登录
     * @param username
     * @param password
     */
    @Override
    public void login(String username, String password) {
        if ("123".equals(username) && "000000".equals(password)) {
            userView.loginSuccess();
        } else {
            userView.loginFail();
        }
    }
}
