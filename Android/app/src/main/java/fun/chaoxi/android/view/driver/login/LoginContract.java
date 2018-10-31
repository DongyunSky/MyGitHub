package fun.chaoxi.android.view.driver.login;

import fun.chaoxi.android.common.base.BasePresenter;
import fun.chaoxi.android.common.base.BaseView;

/**
 * Create by Wing Gao on 2018/10/30 18:54
 */
public interface LoginContract {

    interface Presenter extends BasePresenter {
        void login(String username, String password);
    }

    interface View extends BaseView<Presenter>{

        // 显示隐藏加载动画
        void showLoading(boolean bool);

        // 自动填写用户信息
        void autoFillInUserInfo();

        void finish();
    }
}
