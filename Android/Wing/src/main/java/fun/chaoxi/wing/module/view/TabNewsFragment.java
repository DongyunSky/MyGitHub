package fun.chaoxi.wing.module.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import fun.chaoxi.wing.R;

/**
 * @author Wing Gao
 * @date 2018/12/26 11:08
 * @description
 */
public class TabNewsFragment extends Fragment {

    View newsTabView;

    public static TabNewsFragment getInstance() {
        return new TabNewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        newsTabView = inflater.inflate(R.layout.home_fragment_news_tab, container, false);
        return newsTabView;
    }
}
