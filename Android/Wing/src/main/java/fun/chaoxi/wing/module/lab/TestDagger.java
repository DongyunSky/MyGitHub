package fun.chaoxi.wing.module.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fun.chaoxi.wing.R;
import fun.chaoxi.wing.module.model.entity.User;

/**
 * @author Wing Gao
 * @date 2019/1/7 13:20
 * @description 测试Dagger依赖注入
 */
public class TestDagger extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.login_btn)
    Button loginBtn;

    @Inject
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_lab_dagger);
        ButterKnife.bind(this);

        // 使用Dagger2生成的类生成组件进行构造，并注入
        DaggerActivityComponent.builder().build().inject(this);

        loginBtn.setOnClickListener(this);
    }

    @Override
    @OnClick(R.id.login_btn)
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn :
                user.setId("fstgsdhsgafdsdaagadadf");
                user.setName("aaaa");
                user.setPhone("12345678900");
                Toast.makeText(this, user.toString(), Toast.LENGTH_LONG).show();
            default:break;
        }
    }
}
