package fun.chaoxi.wing.module;

import fun.chaoxi.wing.module.base.BasePresenter;
import fun.chaoxi.wing.module.base.BaseView;

/**
 * @author Wing Gao
 * @date 2018/12/18 15:47
 * @description
 */
public interface LabContract {

    interface View extends BaseView<Presenter> {}

    interface Presenter extends BasePresenter {}
}
