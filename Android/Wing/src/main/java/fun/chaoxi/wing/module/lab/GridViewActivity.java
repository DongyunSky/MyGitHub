package fun.chaoxi.wing.module.lab;

import android.os.Bundle;
import android.widget.GridLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import fun.chaoxi.wing.R;

/**
 * @author Wing Gao
 * @date 2018/12/19 10:24
 * @description
 */
public class GridViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lab_gridview);

        GridLayout gridLayout = findViewById(R.id.grid_layout);
        // 设置最大列，要和布局中的一样或更多
        gridLayout.setColumnCount(gridLayout.getColumnCount());

        // 网格布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this, gridLayout.getColumnCount());

    }
}
