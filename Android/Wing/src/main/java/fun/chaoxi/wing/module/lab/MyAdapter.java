package fun.chaoxi.wing.module.lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import fun.chaoxi.wing.R;

/**
 * @author Wing Gao
 * @date 2018/12/19 16:21
 * @description 设置Grid内容的Adapter
 */
public class MyAdapter extends RecyclerView.Adapter {

    private List<Item> itemList = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<Item> data, Context context) {
        if (itemList != null) {
            this.itemList = data;
        }
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        holder = new MyViewHolder(inflater.inflate(R.layout.item_grid, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.titleText.setText(itemList.get(position).name);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.grid_image_view);
            titleText = itemView.findViewById(R.id.grid_title_tv);
        }
    }

}
