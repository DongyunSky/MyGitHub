package fun.chaoxi.android;

import android.app.Application;
import android.content.Context;

/**
 * Create by Wing Gao on 2018/10/30 18:35
 */
public class MyApplication extends Application {

    public static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = getApplicationContext();
    }

    public static Context getInstance(){
        return instance;
    }
}
