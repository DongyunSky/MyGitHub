package fun.chaoxi.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import fun.chaoxi.testdemo.R;

/**
 * Create by Wing Gao on 2018/11/6 13:23
 */
public class AdapterViewPager extends PagerAdapter {

    private Context context;
    private List<String> stringList;

    public AdapterViewPager(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    /**
     * @return viewPage的个数
     */
    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.pager_view_page, null);
        TextView textView = view.findViewById(R.id.view_pager_text_view);
        textView.setText(stringList.get(position)); // 通过当前viewPager下标
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
