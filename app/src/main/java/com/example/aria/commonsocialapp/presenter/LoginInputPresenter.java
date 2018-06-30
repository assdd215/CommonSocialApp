package com.example.aria.commonsocialapp.presenter;

import android.content.Context;

import com.example.aria.commonsocialapp.base.BasePresenter;
import com.example.aria.commonsocialapp.utils.CommonUtils;

public class LoginInputPresenter extends BasePresenter{


    public LoginInputPresenter(Context context) {
        super(context);
    }

    @Override
    protected void makeFakeData() {

    }

    @Override
    protected void initData() {

    }

    private AccountCallback callback;

    public void login(String account,String password){
        if (CommonUtils.isDebug){
            callback.onLoginResult(AccountCallback.CODE_OK);
        }
    }

    public void register(String account,String password){
        if (CommonUtils.isDebug){
            callback.onRegisterResult(AccountCallback.CODE_OK);
        }
    }

    public void setCallback(AccountCallback callback) {
        this.callback = callback;
    }

    public interface AccountCallback{
        int CODE_OK = 200;

        void onLoginResult(int code);
        void onRegisterResult(int code);
    }
}
