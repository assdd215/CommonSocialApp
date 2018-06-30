package com.example.aria.commonsocialapp.base;

import android.content.Context;

import com.example.aria.commonsocialapp.utils.CommonUtils;

public abstract class BasePresenter {

    protected Context context;

    public BasePresenter(Context context){
        this.context = context;
        initData();
    }

    protected abstract void makeFakeData();
    protected abstract void initData();
}
