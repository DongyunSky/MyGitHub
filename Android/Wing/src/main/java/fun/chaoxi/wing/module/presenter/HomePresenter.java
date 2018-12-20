package fun.chaoxi.wing.module.presenter;

import fun.chaoxi.wing.module.HomeContract;

/**
 * @author Wing Gao
 * @date 2018/12/18 9:53
 * @description
 */
public class HomePresenter implements HomeContract.Presenter {

    HomeContract.View homeFragment;

    public HomePresenter(HomeContract.View homeFragment) {
        this.homeFragment = homeFragment;
        homeFragment.setPresenter(this);
    }

    @Override
    public void start() {
    }
}
