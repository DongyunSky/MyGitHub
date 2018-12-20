package fun.chaoxi.wing.module;

import fun.chaoxi.wing.module.base.BasePresenter;
import fun.chaoxi.wing.module.base.BaseView;

/**
 * @author Wing Gao
 * @date 2018/12/17 17:25
 * @description 启动页|欢迎页|广告页
 */
public interface SplashContract {

    interface View extends BaseView<Presenter> {}

    interface Presenter extends BasePresenter {}
}
