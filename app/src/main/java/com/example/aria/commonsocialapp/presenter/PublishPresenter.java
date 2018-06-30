package com.example.aria.commonsocialapp.presenter;

import android.content.Context;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BasePresenter;
import com.example.aria.commonsocialapp.model.ImgModel;

import java.util.ArrayList;
import java.util.List;

public class PublishPresenter extends BasePresenter{

    private List<ImgModel> itemList;
    private BaseCallback callback;

    public PublishPresenter(Context context) {
        super(context);
    }

    public PublishPresenter(Context context,BaseCallback callback){
        super(context);
        this.callback = callback;
    }

    @Override
    protected void makeFakeData() {

    }

    @Override
    protected void initData() {
        itemList = new ArrayList<>();
        itemList.add(new ImgModel(String.valueOf(R.drawable.img_publish_add),ImgModel.TYPE_ADD));
    }

    public void updateData(List<String> imgUriList){
        if (imgUriList == null){
            callback.onDataLoaded(BaseCallback.CODE_EMPTY);
            return;
        }
        if (itemList == null)
            itemList = new ArrayList<>();
        itemList.clear();
        for (String uri:imgUriList){
            itemList.add(new ImgModel(uri));
        }
        itemList.add(new ImgModel(String.valueOf(R.drawable.img_publish_add),ImgModel.TYPE_ADD));
        callback.onDataLoaded(200);
    }

    public void updateData(){
        updateData(new ArrayList<String>());
    }

    public List<ImgModel> getItemList() {
        return itemList;
    }
}
