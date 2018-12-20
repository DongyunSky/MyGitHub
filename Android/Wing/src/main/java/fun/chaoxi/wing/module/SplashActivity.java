package fun.chaoxi.wing.module;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import fun.chaoxi.wing.Constant;
import fun.chaoxi.wing.MainActivity;
import fun.chaoxi.wing.R;

/**
 * @author Wing Gao
 * @date 2018/12/17 16:26
 * @description 启动页|欢迎页|广告页
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 隐藏标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);

        // 延时后启动主页
        new Thread(){
            @Override
            public void run() {
                try{
                    sleep(Constant.DELAY_TIME);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

        ((Button) findViewById(R.id.skip_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
                Toast.makeText(SplashActivity.this, "点了跳过...", Toast.LENGTH_LONG).show();
            }
        });
    }
}
