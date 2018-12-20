package fun.chaoxi.wing.module.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import fun.chaoxi.wing.R;
import fun.chaoxi.wing.module.HomeActivity;
import fun.chaoxi.wing.module.UserContract;

/**
 * @author Wing Gao
 * @date 2018/12/17 16:23
 * @description
 */
public class UserFragment extends Fragment implements UserContract.View {

    private View loginView;
    private EditText usernameET, passwordET;
    private TextView forgetPwdTV, newUserTV, serverItemTV;
    private Button loginBtn;

    UserContract.Presenter userPresenter;

    public static UserFragment newInstant() {
        return new UserFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginView = inflater.inflate(R.layout.user_login, container, false);
        initView();
        return loginView;
    }

    @Override
    public void setPresenter(@NonNull UserContract.Presenter presenter) {
        userPresenter = presenter;
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getActivity(), "登陆成功..." , Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity(), HomeActivity.class));
        getActivity().finish();
    }

    @Override
    public void loginFail() {
        Toast.makeText(getActivity(), "登陆失败..." , Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity(), HomeActivity.class));
        getActivity().finish();
    }

    private void initView() {
        usernameET = loginView.findViewById(R.id.username_et);
        passwordET = loginView.findViewById(R.id.password_et);
        loginBtn = loginView.findViewById(R.id.login_btn);
        forgetPwdTV = loginView.findViewById(R.id.forget_password_tv);
        newUserTV = loginView.findViewById(R.id.new_user_tv);
        serverItemTV = loginView.findViewById(R.id.server_item_tv);
        bindOnclickListener();
        // 设置文本类密码（默认不可见），这两个属性必须同时设置。InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD -> 可见密码
        passwordET.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
        // 设置光标在最后面，此处没用
        passwordET.setSelection(passwordET.getText().length());
    }

    private void bindOnclickListener() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                userPresenter.login(username, password);
            }
        });
    }
}
