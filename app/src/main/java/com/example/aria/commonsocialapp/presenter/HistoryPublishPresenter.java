package com.example.aria.commonsocialapp.presenter;

import android.content.Context;

import com.example.aria.commonsocialapp.base.BasePresenter;
import com.example.aria.commonsocialapp.base.UserUtils;
import com.example.aria.commonsocialapp.model.ContentModel;
import com.example.aria.commonsocialapp.model.User;
import com.example.aria.commonsocialapp.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class HistoryPublishPresenter extends BasePresenter{

    private List<ContentModel> itemList;
    private BaseCallback callback;

    public HistoryPublishPresenter(Context context) {
        super(context);
    }

    @Override
    protected void makeFakeData() {
        itemList = new ArrayList<>();
        User user = new User(UserUtils.getNickName(),UserUtils.getAvatarUrl());
        itemList.add(new ContentModel(0,"标题1","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529947709209&di=260834e54c231835d67ead8b091b0247&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D9f2afe34f9faaf5184e381b7bc5494ed%2F8a069f014c086e064ca4695906087bf40ad1cb37.jpg",user));
        itemList.add(new ContentModel(0,"标题2","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529947743310&di=9119542eadc24f3304074f50fa4928a7&imgtype=0&src=http%3A%2F%2Fast.ainimei.cn%2Farticles%2F10003138%2Fimg%2Fef243bc91b6f945f5db27f9ee1e65bbd.jpg",user));
        itemList.add(new ContentModel(0,"标题3","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529947914928&di=aaa44b4364711fee92f39272837fa81a&imgtype=0&src=http%3A%2F%2Fimgtu.5011.net%2Fuploads%2Fcontent%2F20160909%2F7072021473407291.jpg",user));
        itemList.add(new ContentModel(0,"标题4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529947798842&di=96acb0d315c7925a576137d91724f670&imgtype=0&src=http%3A%2F%2Fimg2.178.com%2Facg1%2F201403%2F189459648522%2F189713295396.jpg",user));
        itemList.add(new ContentModel(0,"标题1","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529947709209&di=260834e54c231835d67ead8b091b0247&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D9f2afe34f9faaf5184e381b7bc5494ed%2F8a069f014c086e064ca4695906087bf40ad1cb37.jpg",user));
        itemList.add(new ContentModel(0,"标题2","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529947743310&di=9119542eadc24f3304074f50fa4928a7&imgtype=0&src=http%3A%2F%2Fast.ainimei.cn%2Farticles%2F10003138%2Fimg%2Fef243bc91b6f945f5db27f9ee1e65bbd.jpg",user));
        itemList.add(new ContentModel(0,"标题3","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529947914928&di=aaa44b4364711fee92f39272837fa81a&imgtype=0&src=http%3A%2F%2Fimgtu.5011.net%2Fuploads%2Fcontent%2F20160909%2F7072021473407291.jpg",user));
        itemList.add(new ContentModel(0,"标题4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529947798842&di=96acb0d315c7925a576137d91724f670&imgtype=0&src=http%3A%2F%2Fimg2.178.com%2Facg1%2F201403%2F189459648522%2F189713295396.jpg",user));
    }

    @Override
    protected void initData() {

    }

    public List<ContentModel> getItemList() {
        return itemList;
    }

    public void loadData(int page){
        if (CommonUtils.isDebug){
            makeFakeData();
            callback.onDataLoaded(BaseCallback.CODE_OK);
        }
    }

    public void setCallback(BaseCallback callback) {
        this.callback = callback;
    }
}
