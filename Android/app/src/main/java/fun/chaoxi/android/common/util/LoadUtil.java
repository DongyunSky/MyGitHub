package fun.chaoxi.android.common.util;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Create by Wing Gao on 2018/10/31 9:35
 */
public class LoadUtil {

    public static void show(FragmentManager fragmentManager, DialogFragment dialogFragment) {
        dialogFragment.show(fragmentManager, "loading");
    }

    public static void dismiss(FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            Fragment f = fragmentManager.findFragmentByTag("loading");
            if (f != null) {
                FragmentTransaction t = fragmentManager.beginTransaction();
                t.remove(f);
                t.commitAllowingStateLoss();
            }
        }
    }
}
