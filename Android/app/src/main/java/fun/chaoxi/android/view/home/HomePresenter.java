package fun.chaoxi.android.view.home;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by Wing Gao on 2018/10/31 14:39
 */
public class HomePresenter implements HomeContract.Presenter {

    private final String TAG = this.getClass().getName();

    HomeContract.View fragment;
    Context context;
    /**
     * 构造方法
     * @param context
     * @param view
     */
    public HomePresenter(Context context, HomeView view) {
        this.context = context;
        this.fragment = view;
    }

    @Override
    public void getTask(String status) {
        // 展示加载框
        fragment.showLoading(true);
        List<Object> bodyList = new ArrayList<>();
    }

    @Override
    public void updateTaskStatus(String taskId, String taskStatus) {

    }

    @Override
    public void switchTask(String taskId) {

    }

    @Override
    public void uploadOverData(String overTime, String overKm, String overMoney, String taskId, String orderId) {

    }

    @Override
    public void getTaskDetail(String taskId) {

    }

    @Override
    public void pay(String orderId, String taskId, String payChannel) {

    }

    @Override
    public void subScribe() {
        initParams();
    }

    private void initParams() {
        Log.i(TAG, "初始化参数");
    }

    @Override
    public void unSubScribe() {

    }
}
