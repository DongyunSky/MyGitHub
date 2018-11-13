package fun.chaoxi.android.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.Marker;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fun.chaoxi.android.R;
import fun.chaoxi.android.common.bean.DriverTask;
import fun.chaoxi.android.common.widget.CustomListView;
import fun.chaoxi.android.service.LocationService;

/**
 * Create by Wing Gao on 2018/10/31 14:42
 */
public class HomeView extends Fragment implements HomeContract.View, View.OnClickListener,
        AMap.OnMarkerClickListener, INaviInfoCallback {

    View view;
    HomeContract.Presenter presenter;

    int paddingTop, paddingBottom; // 坐标点距离上下的高度


    @BindView(R.id.map)
    MapView mapView;
    @BindView(R.id.toMyLocation)
    ImageView toMyLocation;
    @BindView(R.id.finishAllTask)
    RelativeLayout finishAllTask;
    @BindView(R.id.informImg)
    ImageView informImg;
    @BindView(R.id.flagTv)
    TextView flagTv;
    @BindView(R.id.currentTask)
    TextView currentTask;
    @BindView(R.id.routeStatusTv)
    TextView routeStatusTv;
    @BindView(R.id.routeLayout)
    LinearLayout routeLayout;
    @BindView(R.id.lookTaskTv)
    TextView lookTaskTv;
    @BindView(R.id.bottomLayout)
    RelativeLayout bottomLayout;
    @BindView(R.id.taskListView)
    CustomListView taskListView;
    @BindView(R.id.behaviorLayout)
    LinearLayout behaviorLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_home_view, container, false);
        ButterKnife.bind(this, view);
        mapView.onCreate(savedInstanceState);
        init();
        initMap();
        presenter.subScribe();
        return view;
    }

    private void init() {
        EventBus.getDefault().register(this);
        // 启动位置监听服务，定时上传轨迹数据
        getActivity().startService(new Intent(getActivity(), LocationService.class));

        paddingTop = dip2px(80);
        paddingBottom = dip2px(140);

        behavior = BottomSheetBehavior.from(behaviorLayout);
        // 设置任务列表数据
        taskListAdapter = new TaskListAdapter(getActivity());
        taskListView.setAdapter(taskListAdapter);
        // 初始化alert确认用户的选择
        initDialog();
        // 初始化超时超公里填报
        initPopup();
    }

    public int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onInitNaviFailure() {

    }

    @Override
    public void onGetNavigationText(String s) {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onArriveDestination(boolean b) {

    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {

    }

    @Override
    public void onCalculateRouteFailure(int i) {

    }

    @Override
    public void onStopSpeaking() {

    }

    @Override
    public void onReCalculateRoute(int i) {

    }

    @Override
    public void onExitPage(int i) {

    }

    @Override
    public void onStrategyChanged(int i) {

    }

    @Override
    public View getCustomNaviBottomView() {
        return null;
    }

    @Override
    public View getCustomNaviView() {
        return null;
    }

    @Override
    public void onArrivedWayPoint(int i) {

    }

    @Override
    public void showLoading(boolean b) {

    }

    @Override
    public void getTaskList(List<DriverTask> taskList) {

    }

    @Override
    public void waitPay() {

    }

    @Override
    public void setTaskDetail(String finalMoney, String isReport) {

    }

    @Override
    public void getPayMoneyResult() {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        null.unbind();
    }
}
