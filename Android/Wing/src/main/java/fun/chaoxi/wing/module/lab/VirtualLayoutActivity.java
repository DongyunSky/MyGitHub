package fun.chaoxi.wing.module.lab;

import android.os.Bundle;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import fun.chaoxi.wing.R;

/**
 * @author Wing Gao
 * @date 2018/12/26 9:13
 * @description 阿里开源库VLayout的介绍及使用
 * https://github.com/alibaba/vlayout/blob/master/README-ch.md
 */
public class VirtualLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_vl);

        // 1. 初始化VirtualLayoutManager
        final RecyclerView recyclerView = findViewById(R.id.recycle_view);
        final VirtualLayoutManager vlManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(vlManager);

        // 2. 设置回收复用池大小
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(pool);
        // 为type=0 的设置复用池大小为10
        pool.setMaxRecycledViews(0, 10);

        // 3. 加载数据
        // 一种是使用 DelegateAdapter, 可以像平常一样写继承自DelegateAdapter.Adapter的Adapter, 只比之前的Adapter需要多重载onCreateLayoutHelper方法。 其他的和默认Adapter一样。
        // 另一种是当业务有自定义的复杂需求的时候, 可以继承自VirtualLayoutAdapter, 实现自己的Adapter
        // 其实都是第二种，因为DelegateAdapter extends VirtualLayoutAdapter<RecyclerView.ViewHolder>
        // 当hasConsistItemType=true的时候，不论是不是属于同一个子adapter，相同类型的item都能复用。表示它们共享一个类型。
        // 当hasConsistItemType=false的时候，不同子adapter之间的类型不共享。默认是false
        // 3.1. DelegateAdapter
        DelegateAdapter delegateAdapter = new DelegateAdapter(vlManager, true);

        // 3.2 创建你的各种adapter并添加到delegateAdapter中
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        NewsAdapter newsAdapter = new NewsAdapter(linearLayoutHelper);
        delegateAdapter.addAdapter(newsAdapter);

        // 最后设置adapter
        recyclerView.setAdapter(delegateAdapter);
    }
}
