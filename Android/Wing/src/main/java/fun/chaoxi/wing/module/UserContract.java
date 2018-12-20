package fun.chaoxi.wing.module;

import fun.chaoxi.wing.module.base.BasePresenter;
import fun.chaoxi.wing.module.base.BaseView;

/**
 * @author Wing Gao
 * @date 2018/12/17 16:04
 * @description 用户模块
 * 用户的登录、注册、等功能
 */
public interface UserContract {

    interface View extends BaseView<Presenter> {

        void loginSuccess();

        void loginFail();
    }

    interface Presenter extends BasePresenter {

        /**
         * 用户登录
         * @param username
         * @param password
         */
        void login(String username, String password);
    }
}
