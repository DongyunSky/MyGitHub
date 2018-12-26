package fun.chaoxi.wing.module.lab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import fun.chaoxi.wing.R;

/**
 * @author Wing Gao
 * @date 2018/12/26 10:01
 * @description
 */
public class NewsAdapter extends DelegateAdapter.Adapter {
    private LayoutHelper mLayoutHelper;
    private int count = 3;
    private int refreshTimes = 0;

    public NewsAdapter(LayoutHelper layoutHelper) {
        this.mLayoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid,viewGroup,false);
            return new RecyclerView.ViewHolder(view) {
            };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
    }

    @Override
    public int getItemCount() {
        return count+refreshTimes;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 5;
        }
        return 4;
    }

    public void refresh(){
        refreshTimes++ ;
        notifyDataSetChanged();
    }
}
