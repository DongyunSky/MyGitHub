package fun.chaoxi.toutiao;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import fun.chaoxi.toutiao.module.base.BaseActivity;
import fun.chaoxi.toutiao.module.media.channel.MediaChannelView;
import fun.chaoxi.toutiao.module.setting.SettingActivity;
import fun.chaoxi.toutiao.util.SettingUtils;

/**
 * @author Wing Gao
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private static final String POSITION = "position";
    private static final String SELECT_ITEM = "bottomNavigationSelectItem";
    private static final int FRAGMENT_NEWS = 0;
    private static final int FRAGMENT_PHOTO = 1;
    private static final int FRAGMENT_VIDEO = 2;
    private static final int FRAGMENT_MEDIA = 3;
//    private NewsTabLayout newsTabLayout;
//    private PhotoTabLayout photoTabLayout;
//    private VideoTabLayout videoTabLayout;
    private MediaChannelView mediaChannelView;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private long exitTime = 0;
    private long firstClickTime = 0;
    private int position;

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        // action_search 搜索菜单
        toolbar.inflateMenu(R.menu.menu_activity_main);
        // 滚动隐藏
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_news:
                        Toast.makeText(MainActivity.this, "新闻", Toast.LENGTH_SHORT).show();
//                        showFragment(FRAGMENT_NEWS);
//                        doubleClick(FRAGMENT_NEWS);
                        break;
                    case R.id.action_photo:
                        Toast.makeText(MainActivity.this, "图", Toast.LENGTH_SHORT).show();
//                        showFragment(FRAGMENT_PHOTO);
//                        doubleClick(FRAGMENT_PHOTO);
                        break;
                    case R.id.action_video:
                        Toast.makeText(MainActivity.this, "video", Toast.LENGTH_SHORT).show();
//                        showFragment(FRAGMENT_VIDEO);
//                        doubleClick(FRAGMENT_VIDEO);
                        break;
                    case R.id.action_media:
                        Toast.makeText(MainActivity.this, "头条号", Toast.LENGTH_SHORT).show();
//                        showFragment(FRAGMENT_MEDIA);
                        break;
                    default:break;
                }
                return true;
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        // onNavigationItemSelected
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * android.support.design.widget.NavigationView.OnNavigationItemSelectedListener
     * @param menuItem
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_account:
                Toast.makeText(this, "账号功能未实现", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
                return false;
            case R.id.nav_switch_night_mode:
                int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (mode == Configuration.UI_MODE_NIGHT_YES) {
                    SettingUtils.getInstance().setIsNightMode(false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    SettingUtils.getInstance().setIsNightMode(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
                recreate();
                return false;
            case R.id.nav_setting:
                Toast.makeText(this, "设置功能未实现", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SettingActivity.class));
                drawerLayout.closeDrawers();
                return false;
            case R.id.nav_share:
                Intent shareIntent = new Intent()
                        .setAction(Intent.ACTION_SEND)
                        .setType("text/plain")
                        .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_app_text) + getString(R.string.source_code_url));
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_to)));
                drawerLayout.closeDrawers();
                return false;
            default:break;
        }
        return false;
    }
}
