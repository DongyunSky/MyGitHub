package fun.chaoxi.fileprovider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import fun.chaoxi.testdemo.R;

/**
 * Create by Wing Gao on 2018/11/21 13:50
 */
public class ProviderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);

        ((TextView) findViewById(R.id.update_app_tv)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // final String target = "/storage/emulated/0/files/Gen_Signature_Android2.apk";
                final String target = "/storage/emulated/0/files/";

                new AlertDialog.Builder(ProviderActivity.this)
                        .setTitle("版本更新")
                        .setMessage("更新已下载，请确认安装...")
                        .setCancelable(false)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                File file = new File(target, "Gen_Signature_Android2.apk");
                                Intent intent = new Intent();
                                intent.setAction("android.intent.action.VIEW");
                                intent.addCategory("android.intent.category.DEFAULT");
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    Uri data = FileProvider.getUriForFile(ProviderActivity.this,
                                            "fun.chaoxi.testdemo.fileprovider", file);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                                    intent.setDataAndType(data, "application/vnd.android.package-archive");
                                } else {
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
                                }
                                startActivity(intent);
                            }
                        }).setNegativeButton("退出", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProviderActivity.this.finish();
                    }
                }).show();
            }
        });
    }
}
