package fun.chaoxi.wing.module;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import fun.chaoxi.wing.R;
import fun.chaoxi.wing.module.presenter.HomePresenter;
import fun.chaoxi.wing.module.view.HomeFragment;

/**
 * @author Wing Gao
 * @date 2018/12/18 9:33
 * @description
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        // ViewFragment
        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.content_home_fl);
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstant();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.content_home_fl, homeFragment);
            transaction.commit();
        }

        // Presenter
        new HomePresenter(homeFragment);
    }
}
