package fun.chaoxi.toutiao.module.setting;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import fun.chaoxi.toutiao.R;
import fun.chaoxi.toutiao.module.base.BaseActivity;

/**
 * @author Wing Gao
 * @date 2018/12/13 18:03
 * @description
 */
public class SettingActivity extends BaseActivity {
    public static final String EXTRA_SHOW_FRAGMENT = "show_fragment";
    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = "show_fragment_args";
    public static final String EXTRA_SHOW_FRAGMENT_TITLE = "show_fragment_title";

    private void setupFragment(String fragmentName, Bundle args) {
        Fragment fragment = Fragment.instantiate(this, fragmentName, args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.container, fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        String initFragment = getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT);
        Bundle initArguments = getIntent().getBundleExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS);
        String initTitle = getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT_TITLE);

        if (TextUtils.isEmpty(initFragment)) {
            setupFragment(GeneralPreferenceFragment.class.getName(), initArguments);
        } else {
            setupFragment(initFragment, initArguments);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        initToolBar(toolbar, true, TextUtils.isEmpty(initTitle) ? getString(R.string.title_settings) : initTitle);
    }
}
