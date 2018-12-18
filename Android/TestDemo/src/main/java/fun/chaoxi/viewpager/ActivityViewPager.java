package fun.chaoxi.viewpager;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import fun.chaoxi.testdemo.R;

/**
 * Create by Wing Gao on 2018/11/6 13:14
 */
public class ActivityViewPager extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_pager_view_pager);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add("第" + i + "个View");
        }
        ViewPager vp = (ViewPager) findViewById(R.id.view_pager);
        vp.setAdapter(new AdapterViewPager(this, list));
    }
}
