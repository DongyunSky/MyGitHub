package fun.chaoxi.wing.module;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import fun.chaoxi.wing.R;
import fun.chaoxi.wing.module.presenter.UserPresenter;
import fun.chaoxi.wing.module.view.UserFragment;

/**
 * @author Wing Gao
 * @date 2018/12/17 17:59
 * @description
 */
public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 隐藏标题栏
        getSupportActionBar().hide();
        // 设置当前view
        setContentView(R.layout.activity_user);

        // view
        UserFragment userFragment = (UserFragment) getSupportFragmentManager().findFragmentById(R.id.content_fl);
        if (userFragment == null) {
            userFragment = UserFragment.newInstant();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.content_fl, userFragment);
            transaction.commit();
        }

        // presenter
        new UserPresenter(userFragment);
    }
}
