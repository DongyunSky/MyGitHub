package fun.chaoxi.android.common.util;

import android.widget.Toast;

import fun.chaoxi.android.MainActivity;
import fun.chaoxi.android.MyApplication;

/**
 * Create by Wing Gao on 2018/10/30 18:32
 */
public class ToastUtil {
    public static void show(Object object) {
        Toast.makeText(MyApplication.getInstance(), object + "", Toast.LENGTH_SHORT).show();
    }
}
