package fun.chaoxi.PageIndicatorView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import fun.chaoxi.testdemo.R;

/**
 * Create by Wing Gao on 2018/11/12 10:02
 */
public class adapter extends PagerAdapter {
    List<View> views = new ArrayList<>();

    public void setData(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        for (int i = 0; i < 5; i++) {
            View view = inflater.inflate(R.layout.text_view, null);
            TextView textView = view.findViewById(R.id.text_view);
            textView.setText("viewPager:" + i);
            views.add(view);
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(views.get(position));
        Log.e("adapter", "" + position);
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
