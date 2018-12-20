package fun.chaoxi.wing.module.presenter;

import fun.chaoxi.wing.module.LabContract;

/**
 * @author Wing Gao
 * @date 2018/12/18 15:57
 * @description
 */
public class LabPresenter implements LabContract.Presenter {

    private LabContract.View labFragment;

    public LabPresenter(LabContract.View labFragment) {
        this.labFragment = labFragment;
        labFragment.setPresenter(this);
    }

    @Override
    public void start() {
    }
}
