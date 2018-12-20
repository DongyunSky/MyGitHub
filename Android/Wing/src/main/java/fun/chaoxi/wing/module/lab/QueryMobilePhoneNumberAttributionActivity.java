package fun.chaoxi.wing.module.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import fun.chaoxi.wing.Config;
import fun.chaoxi.wing.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Wing Gao
 * @date 2018/12/20 14:54
 * @description 查询手机号码归属地
 */
public class QueryMobilePhoneNumberAttributionActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText phoneNumberET;
    private Button submitBtn;
    private TextView defaultTV, phoneNumTV, phoneNumAttributionTV;
    private LinearLayout resultLL;

    private PhoneNumAttr phoneNumAttr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_query_mobil_phone_num_attribution);

        phoneNumberET = findViewById(R.id.phone_num_et);
        submitBtn = findViewById(R.id.submit_btn);
        defaultTV = findViewById(R.id.default_tv);
        resultLL = findViewById(R.id.result_ll);
        phoneNumTV = findViewById(R.id.phone_num_tv);
        phoneNumAttributionTV = findViewById(R.id.phone_num_attribution_tv);

        defaultTV.setVisibility(View.VISIBLE);
        resultLL.setVisibility(View.INVISIBLE);

        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_btn :
                queryAttribution(phoneNumberET.getText().toString());
                break;
            default:break;
        }
    }

    /**
     * 查询号码归属地
     * @param phoneNum
     */
    private void queryAttribution(final String phoneNum) {
        // 创建Request对象
        final Request request = new Request.Builder()
                .url(Config.GET_ATTRIBUTION_OF_PHONE + "?tel=" + phoneNum)
                .build();
        Toast.makeText(this, request.toString(), Toast.LENGTH_SHORT).show();
        // 创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        // 通过Client使用Request构建一个call对象
        Call call = client.newCall(request);
        // 异步方式执行请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                showResult(false);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    String[] results = response.body().string().split("=");
                    phoneNumAttr = new Gson().fromJson(results[1], PhoneNumAttr.class);
                    showResult(true);
                } else {
                    showResult(false);
                }
            }
        });
    }

    /**
     * 展示查询结果
     * @param isSuccess 是否查询成功
     */
    private void showResult(final boolean isSuccess) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (isSuccess) {
                    Toast.makeText(QueryMobilePhoneNumberAttributionActivity.this,
                            phoneNumAttr.toString(), Toast.LENGTH_LONG).show();
                    defaultTV.setVisibility(View.INVISIBLE);
                    resultLL.setVisibility(View.VISIBLE);
                    phoneNumTV.setText(phoneNumAttr.getTelString());
                    phoneNumAttributionTV.setText(phoneNumAttr.getCarrier());
                } else {
                    Toast.makeText(QueryMobilePhoneNumberAttributionActivity.this,
                            "请求失败...", Toast.LENGTH_LONG).show();
                    defaultTV.setVisibility(View.VISIBLE);
                    resultLL.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
