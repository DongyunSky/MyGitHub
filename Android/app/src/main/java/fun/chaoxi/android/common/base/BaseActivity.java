package fun.chaoxi.android.common.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import fun.chaoxi.android.common.util.ActivityManager;
import fun.chaoxi.android.common.util.ToastUtil;

/**
 * Create by Wing Gao on 2018/10/30 17:14
 * Activity 的基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    NetWorkChange netWorkChange;
    public boolean netIsAvailable = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置layout
        setContentView(getLayout());
        // ButterKnife 绑定
        ButterKnife.bind(this);
        // 添加到管理返回栈中
        ActivityManager.addActivity(this);
        // 初始化操作
        init();
    }

    protected abstract int getLayout();

    protected abstract void init();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.removeActivity(this);
        if (netWorkChange != null) {
            unregisterReceiver(netWorkChange);
        }
    }

    /**
     * 网络状态广播监听
     */
    class NetWorkChange extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager =(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null && networkInfo.isConnected()){
                netIsAvailable =true;
            }else{
                netIsAvailable=false;
                ToastUtil.show("网络错误，请检查网络连接后重试！");
            }
        }
    }
}
