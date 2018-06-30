package com.example.aria.commonsocialapp.activity;

import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BaseActivity;
import com.example.aria.commonsocialapp.presenter.LoginInputPresenter;
import com.example.aria.commonsocialapp.utils.Constants;

import butterknife.BindView;

public class LoginInputActivity extends BaseActivity{

    private boolean isLogin;

    @BindView(R.id.et_account)
    AppCompatEditText etAccount;
    @BindView(R.id.et_password)
    AppCompatEditText etPassword;
    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;

    private LoginInputPresenter presenter;

    @Override
    protected void initData() {
        isLogin = getIntent().getBooleanExtra(Constants.KEY_ISLOGIN,true);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAccountIsValid(etAccount.getText().toString()) && checkPwdIsValid(etPassword.getText().toString())){
                    if (isLogin){
                        presenter.login(etAccount.getText().toString(),etPassword.getText().toString());
                    }else
                        presenter.register(etAccount.getText().toString(),etPassword.getText().toString());
                }
            }
        });

        btnLogin.setText(isLogin ? R.string.login_input_btn_login : R.string.login_input_btn_register);

        presenter = new LoginInputPresenter(this);
        presenter.setCallback(new LoginInputPresenter.AccountCallback() {
            @Override
            public void onLoginResult(int code) {
                if (code == 200){
                    //TODO 这里初始化UserUtils的User信息 并且保存到本地
                    Intent intent = new Intent(LoginInputActivity.this,HomeActivity.class);
                    startActivity(intent);
                    LoginInputActivity.this.finish();
                }
            }

            @Override
            public void onRegisterResult(int code) {
                if (code == 200){
                    presenter.login(etAccount.getText().toString(),etPassword.getText().toString());
                }
            }
        });
    }

    private boolean checkAccountIsValid(String account){
        if (account == null || account.length() == 0){
            Toast.makeText(this,"输入的账号为空！",Toast.LENGTH_SHORT).show();
            return false;
        }

        //TODO 其次做检查账号长度和合法规则等
       return true;
    }

    private boolean checkPwdIsValid(String pwd){
        if (pwd == null || pwd.length() == 0){
            Toast.makeText(this,"输入的密码为空！",Toast.LENGTH_SHORT).show();
        }
        //TODO 其次做检查密码长度和合法规则等
        return true;
    }



    @Override
    protected int layoutId() {
        return R.layout.activity_login_input;
    }
}
