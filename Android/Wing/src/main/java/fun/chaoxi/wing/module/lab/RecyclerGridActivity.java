package fun.chaoxi.wing.module.lab;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fun.chaoxi.wing.R;

/**
 * @author Wing Gao
 * @date 2018/12/19 14:28
 * @description Recycler + GridLayoutManager 完成类似九宫格布局
 */
public class RecyclerGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lab_recycler_grid);

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);

        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            Item item = new Item();
            item.name = i + "个";
            itemList.add(item);
        }
        MyAdapter adapter = new MyAdapter(itemList, this);
        recyclerView.setAdapter(adapter);
    }
}
