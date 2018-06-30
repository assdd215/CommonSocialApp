package com.example.aria.commonsocialapp.presenter;

import android.content.Context;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BasePresenter;
import com.example.aria.commonsocialapp.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePagePresenter extends BasePresenter{

    private List<String> titleList;
    private BaseCallback callback;

    public HomePagePresenter(Context context) {
        super(context);
    }

    public HomePagePresenter(Context context,BaseCallback callback){
        super(context);
        this.callback = callback;
    }

    @Override
    protected void makeFakeData() {
        titleList = new ArrayList<>();
        titleList.add(context.getString(R.string.home_tab_recommend));
        titleList.add(context.getString(R.string.home_tab_theme_eat));
        titleList.add(context.getString(R.string.home_tab_theme_wear));
        callback.onDataLoaded(BaseCallback.CODE_OK);
    }

    @Override
    protected void initData() {

    }

    public void updateTabData(){
        if (CommonUtils.isDebug){
            makeFakeData();
        }else {
            //TODO 服务器请求tab数据
        }
    }

    public void setCallback(BaseCallback callback) {
        this.callback = callback;
    }

    public List<String> getTitleList() {
        return titleList;
    }
}
