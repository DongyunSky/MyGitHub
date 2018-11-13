package fun.chaoxi.android.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by Wing Gao on 2018/11/1 10:21
 */
public class LocationService extends Service {

    private final String TAG = this.getClass().getName();
    private static final String NOTIFICATION_CHANNEL_NAME = "BackgroundLocation";

    NotificationManager notificationManager = null;
    boolean isCreateChannel = false;
    boolean upLoading = true; // 是否正在上传
    public AMapLocationClientOption mLocationOption = null;
    public AMapLocationClient mLocationClient = null;
    String userToken, orderId, taskId, driverId, userType, appId, taskStatus;
    List<Map<String, Object>> locationList = new ArrayList<>();
    Thread thread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        upLoading = true;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (upLoading) {
                    try {
                        Thread.sleep(20000);
                        upLoadPoints(); // 上传点数据
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
