package fun.chaoxi.wing.module;

import fun.chaoxi.wing.module.base.BasePresenter;
import fun.chaoxi.wing.module.base.BaseView;

/**
 * @author Wing Gao
 * @date 2018/12/17 15:20
 * @description
 */
public interface HomeContract {

    interface View extends BaseView<Presenter> {}

    interface Presenter extends BasePresenter {}
}
