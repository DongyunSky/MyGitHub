package fun.chaoxi.toutiao.module.base;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.afollestad.materialdialogs.color.CircleView;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrInterface;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Lifecycle;
import fun.chaoxi.toutiao.Constant;
import fun.chaoxi.toutiao.R;
import fun.chaoxi.toutiao.util.SettingUtils;

/**
 * @author Wing Gao
 * @date 2018/12/3 13:30
 * @description
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private int iconType = -1;

    protected SlidrInterface slidrInterface;
    protected Context mContext;

    /**
     * 初始化 Toolbar
     * @param toolbar
     * @param homeAsUpEnabled
     * @param title
     */
    protected void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    /**
     * 初始化滑动返回
     */
    protected void initSlidable() {
        int isSlidable = SettingUtils.getInstance().getSlidable();
        // 判断是否要禁用滑动返回
        if (isSlidable != Constant.SLIDABLE_DISABLE) {
            SlidrConfig config = new SlidrConfig.Builder()
                    .edge(isSlidable == Constant.SLIDABLE_EDGE)
                    .build();
            slidrInterface = Slidr.attach(this, config);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.iconType = SettingUtils.getInstance().getCustomIconValue();
        this.mContext = this;
        initSlidable();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int color = SettingUtils.getInstance().getColor();
        int drawable = Constant.ICONS_DRAWABLES[SettingUtils.getInstance().getCustomIconValue()];

        if (getSupportActionBar() != null) {
            // 设置主体色
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(CircleView.shiftColorDown(color));
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(
                    getString(R.string.app_name),
                    BitmapFactory.decodeResource(getResources(), drawable),
                    color);
            setTaskDescription(taskDescription);
            if (SettingUtils.getInstance().getNavBar()) {
                getWindow().setNavigationBarColor(CircleView.shiftColorDown(color));
            } else {
                getWindow().setNavigationBarColor(Color.BLACK);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * android.support.v4.app.FragmentActivity
     */
    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    /**
     * android.support.v7.app.AppCompatActivity
     */
    @Override
    protected void onStop() {
        if (iconType != SettingUtils.getInstance().getCustomIconValue()) {
            // 说明用户修改了桌面图标风格
            new Thread(() -> {
                String act = ".SplashActivity_";
                for (String s : Constant.ICONS_TYPE) {
                    // 隐藏应用图标
                    getPackageManager().setComponentEnabledSetting(
                            new ComponentName(BaseActivity.this, getPackageName() + act + s),
                            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                            PackageManager.DONT_KILL_APP);

                    act += Constant.ICONS_TYPE[SettingUtils.getInstance().getCustomIconValue()];
                    // 显示最新设置的应用图标
                    getPackageManager().setComponentEnabledSetting(
                            new ComponentName(BaseActivity.this, getPackageName() + act),
                            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                            PackageManager.DONT_KILL_APP);
                }
            }).start();
        }

        super.onStop();
    }

    /**
     * 干嘛的 不知道
     * @param <X>
     * @return
     */
    public <X> AutoDisposeConverter<X> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }
}
