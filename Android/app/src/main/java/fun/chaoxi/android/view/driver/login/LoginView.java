package fun.chaoxi.android.view.driver.login;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fun.chaoxi.android.R;
import fun.chaoxi.android.common.util.LoadUtil;
import fun.chaoxi.android.common.widget.DialogLoading;

/**
 * Create by Wing Gao on 2018/10/30 18:55
 */
public class LoginView extends Fragment implements LoginContract.View {

    View view;
    LoginContract.Presenter presenter;

    @BindView(R.id.login_logo_iv)
    ImageView loginLogoIv;
    @BindView(R.id.login_username_et)
    EditText loginUsernameEt;
    @BindView(R.id.login_password_et)
    EditText loginPasswordEt;
    @BindView(R.id.login_ll)
    LinearLayout loginLl;
    @BindView(R.id.login_forget_tv)
    TextView loginForgetTv;
    @BindView(R.id.login_login_button)
    Button loginLoginButton;
    @BindView(R.id.login_read_law_ll)
    LinearLayout loginReadLawLl;
    @BindView(R.id.login_law_tv)
    TextView loginLawTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        // 内容初始化
        init();
        // 数据初始化
        presenter.subScribe();
        return view;
    }

    private void init() {
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.lawString));
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.colorLaw));

        spannableString.setSpan(foregroundColorSpan, 1, 10, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE);
        loginLawTv.setText(spannableString);
    }

    // 输入验证
    @OnClick({R.id.login_login_button})
    void click(View view) {
        String username = loginUsernameEt.getText().toString();
        String password = loginPasswordEt.getText().toString();
        presenter.login(username, password);
    }

    @Override
    public void showLoading(boolean bool) {
        if (bool) {
            LoadUtil.show(getFragmentManager(), new DialogLoading());
        } else {
            LoadUtil.dismiss(getFragmentManager());
        }
    }

    @Override
    public void autoFillInUserInfo() {

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void finish() {
        Objects.requireNonNull(getActivity()).finish();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.unSubScribe();
    }
}
