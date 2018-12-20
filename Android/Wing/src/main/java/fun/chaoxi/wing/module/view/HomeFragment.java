package fun.chaoxi.wing.module.view;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import fun.chaoxi.wing.Constant;
import fun.chaoxi.wing.R;
import fun.chaoxi.wing.module.HomeContract;

/**
 * @author Wing Gao
 * @date 2018/12/18 9:52
 * @description
 */
public class HomeFragment extends Fragment implements HomeContract.View {

    private View homeView;
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private LabFragment labFragment;

    HomeContract.Presenter homePresenter;

    public static HomeFragment newInstant() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.home_main, container, false);
        initView();

        // TODO
        if (savedInstanceState == null) {
            showContentFragment(Constant.NEWS_TAB);
        } else {}

        return homeView;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.homePresenter = presenter;
    }

    /**
     * 初始化组件
     */
    private void initView() {
        homeView.findViewById(R.id.drawer_layout);
        homeView.findViewById(R.id.app_bar_layout);
        toolbar = homeView.findViewById(R.id.toolbar);
        homeView.findViewById(R.id.content);
        homeView.findViewById(R.id.nav_view);
        bottomNavigationView = homeView.findViewById(R.id.bottom_navigation);
        bindOnclickListener();
    }

    /**
     * 给组件绑定事件
     */
    private void bindOnclickListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_main :
                        showContentFragment(Constant.NEWS_TAB);
                        break;
                    case R.id.action_favorite :
                        showContentFragment(Constant.FAVORITE_TAB);
                        break;
                    case R.id.action_add :
                        showContentFragment(Constant.ADD_TAB);
                        break;
                    case R.id.action_lab :
                        showContentFragment(Constant.LAB_TAB);
                        break;
                    case R.id.action_user :
                        showContentFragment(Constant.USER_TAB);
                        break;
                    default:break;
                }
                return true;
            }
        });
    }

    /**
     * 根据下标展示不同标签页
     */
    private void showContentFragment(int index) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        // 如果tab不是null就先隐藏起来
        if (labFragment != null) {
            transaction.hide(labFragment);
        }
        switch (index) {
            case Constant.NEWS_TAB :
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    toolbar.setTitle(R.string.title_news);
                }
                break;
            case Constant.FAVORITE_TAB :
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    toolbar.setTitle(R.string.title_favorite);
                }
                break;
            case Constant.ADD_TAB :
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    toolbar.setTitle(R.string.title_add);
                }
                break;
            case Constant.LAB_TAB :
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    toolbar.setTitle(R.string.title_lab);
                }
                if (labFragment == null) {
                    labFragment = LabFragment.getInstance();
                    transaction.add(R.id.content, labFragment, LabFragment.class.getName());
                } else {
                    transaction.show(labFragment);
                }
                break;
            case Constant.USER_TAB :
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    toolbar.setTitle(R.string.title_user);
                }
                break;
            default:break;
        }
        transaction.commit();
    }
}
