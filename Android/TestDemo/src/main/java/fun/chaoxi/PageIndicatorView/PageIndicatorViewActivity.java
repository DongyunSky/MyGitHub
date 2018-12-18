package fun.chaoxi.PageIndicatorView;


import android.app.Activity;
import android.os.Bundle;

import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import fun.chaoxi.testdemo.R;

/**
 * Create by Wing Gao on 2018/11/8 14:14
 * 测试PageIndicatorView
 */
public class PageIndicatorViewActivity extends Activity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.pageIndicatorView)
    PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_indicator_view_main);
        ButterKnife.bind(this);

        adapter adapter = new adapter();
        adapter.setData(this);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        PageIndicatorView pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setAnimationType(AnimationType.THIN_WORM);
        pageIndicatorView.setViewPager(viewPager);
    }
}
