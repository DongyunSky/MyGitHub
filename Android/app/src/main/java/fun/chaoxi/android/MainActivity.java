package fun.chaoxi.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fun.chaoxi.android.view.driver.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();

    @BindView(R.id.index_top_tv)
    TextView indexTopTv;
    @BindView(R.id.index_et_username)
    EditText indexEtUsername;
    @BindView(R.id.index_et_password)
    EditText indexEtPassword;
    @BindView(R.id.index_ll)
    LinearLayout indexLl;
    @BindView(R.id.index_button_login)
    Button indexButtonLogin;
    @BindView(R.id.index_button_info)
    Button indexButtonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "加载主界面");
        ButterKnife.bind(this);
    }

    /**
     * 绑定点击事件
     * @param view 所点击的元素
     */
    @OnClick({R.id.index_top_tv, R.id.index_et_username, R.id.index_et_password,
            R.id.index_ll, R.id.index_button_login, R.id.index_button_info})
    void click(View view) {
        switch (view.getId()) {
            case R.id.index_button_info:
                // 更多信息
                toMoreInfo();
                break;
            default:
                Log.i(TAG, "点了其他元素");
                break;
        }
    }

    private void toMoreInfo() {
        // Param1:Context上下文; Param2:目标.
        Log.i(TAG, "去主页登录");
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
