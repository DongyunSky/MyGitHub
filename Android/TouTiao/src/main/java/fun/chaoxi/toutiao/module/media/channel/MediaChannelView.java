package fun.chaoxi.toutiao.module.media.channel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import fun.chaoxi.toutiao.R;
import fun.chaoxi.toutiao.bean.media.MediaChannelBean;
import fun.chaoxi.toutiao.database.dao.MediaChannelDao;
import fun.chaoxi.toutiao.interfaces.IOnItemLongClickListener;
import fun.chaoxi.toutiao.util.SettingUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @author Wing Gao
 * @date 2018/12/13 14:23
 * @description
 */
public class MediaChannelView extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "MediaChannelView";
    private static MediaChannelView instance = null;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private MultiTypeAdapter adapter;
    private TextView descTV;
    private String isFirstTime = "isFirstTime";
    private List<MediaChannelBean> list;
    private MediaChannelDao dao = new MediaChannelDao();

    public static MediaChannelView getInstance() {
        if (instance == null) {
            instance = new MediaChannelView();
        }
        return instance;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        // 确定Item改变不会影响宽高时设置，通过Adapter的增删改插方法去刷新而不是通过notifyDataSetChanged()
        // 其实可以直接设置为true，当需要改变宽高的时候就用notifyDataSetChanged()去整体刷新一下
        recyclerView.setHasFixedSize(true);
        // 设置展示方式，目前是竖着
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        swipeRefreshLayout = view.findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setColorSchemeColors(SettingUtils.getInstance().getColor());
        swipeRefreshLayout.setOnRefreshListener(this);
        descTV = view.findViewById(R.id.tv_desc);

        IOnItemLongClickListener listener = new IOnItemLongClickListener() {
            @Override
            public void onLongClick(View view, int position) {
                MediaChannelBean item = list.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("取消订阅\" " + item.getName() + " \"?");
                builder.setPositiveButton(R.string.button_enter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new Thread(() -> {
                            dao.delete(item.getId());
                            setAdapter();
                        }).start();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton(R.string.button_cancel, (dialog, which) -> dialog.dismiss());
                builder.show();
            }
        };
        adapter = new MultiTypeAdapter();
//        Register.registerMediaChannelItem(adapter, listener);
//        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        SharedPreferences editor = getActivity().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        boolean result = editor.getBoolean(isFirstTime, true);
        if (result) {
            dao.initData();
            editor.edit().putBoolean(isFirstTime, false).apply();
        }
        setAdapter();
    }

    private void setAdapter() {
        Observable.create((ObservableOnSubscribe<List<MediaChannelBean>>) e -> {
                    list = dao.queryAll();
                    e.onNext(list);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                        .from(this, Lifecycle.Event.ON_DESTROY)))
                .subscribe(list -> {
                    adapter.setItems(list);
                    adapter.notifyDataSetChanged();
                    if (list.size() == 0) {
                        descTV.setVisibility(View.VISIBLE);
                    } else {
                        descTV.setVisibility(View.GONE);
                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media, container, false);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        swipeRefreshLayout.setColorSchemeColors(SettingUtils.getInstance().getColor());
        setAdapter();
    }

    /**
     * android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
     */
    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        setAdapter();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (instance != null) {
            instance = null;
        }
    }
}
