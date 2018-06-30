package com.example.aria.commonsocialapp.activity;

import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.view.WindowManager;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BaseActivity;
import com.example.aria.commonsocialapp.utils.CommonUtils;
import com.example.aria.commonsocialapp.utils.Constants;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity{

    @BindView(R.id.btnLogin)
    AppCompatButton btnLogin;
    @BindView(R.id.btnRegisgter)
    AppCompatButton btnRegister;


    @Override
    protected void initData() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.btnLogin,R.id.btnRegisgter})
    void onClick(View view){

        Intent intent = new Intent(LoginActivity.this,LoginInputActivity.class);
        intent.putExtra(Constants.KEY_ISLOGIN,view.getId() == R.id.btnLogin);
        startActivity(intent);
        LoginActivity.this.finish();
    }
}
