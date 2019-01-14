package fun.chaoxi.wing.module.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import fun.chaoxi.wing.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Wing Gao
 * @date 2019/1/14 10:12
 * @description
 */
public class TestRxActivity extends AppCompatActivity {

    @BindView(R.id.show_content_tv)
    TextView showContentTv;
    @BindView(R.id.get_data_btn)
    Button getDataBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lab_rx);
        ButterKnife.bind(this);

        getDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        System.out.println("ObservableOnSubscribe.subscribe: " + Thread.currentThread());
                        if (!emitter.isDisposed()) {
                            for (int i = 0; i < 10; i++) {
                                // 模拟一个费时的请求接口操作
                                Thread.sleep(1000);
                                emitter.onNext(i);
                            }
                            emitter.onComplete();
                        }
                    }
                }).map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer i) throws Exception {
                        return i + "";
                    }
                }).subscribeOn(Schedulers.newThread()
                ).observeOn(AndroidSchedulers.mainThread()
                ).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe: " + Thread.currentThread());
                        showContentTv.setText("onSubscribe");
                    }

                    @Override
                    public void onNext(String integer) {
                        System.out.println("onNext: " + integer);
                        showContentTv.setText(integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                        showContentTv.setText(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete: " + Thread.currentThread());
                        showContentTv.setText("onComplete");
                    }
                });
            }
        });
    }

}
