package com.example.aria.commonsocialapp.presenter;

import android.content.Context;

import com.example.aria.commonsocialapp.base.BasePresenter;
import com.example.aria.commonsocialapp.model.ContentModel;
import com.example.aria.commonsocialapp.model.User;
import com.example.aria.commonsocialapp.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePageContentPresenter extends BasePresenter{

    private List<ContentModel> itemList;
    private BaseCallback callback;

    public HomePageContentPresenter(Context context) {
        super(context);
    }

    public HomePageContentPresenter(Context context,BaseCallback callback) {
        super(context);
        this.callback = callback;
    }

    @Override
    protected void makeFakeData() {
        itemList = new ArrayList<>();
        itemList.add(new ContentModel(1,"测试用，最大行数为显示2行","http://www.topit.cc/uploads/20180303/17/1520067695-JCbRdpjgot.jpg",
                new User("用户","http://www.topit.cc/uploads/20180303/17/1520067695-JCbRdpjgot.jpg")));
        itemList.add(new ContentModel(2,"目前标题尽量双行，单行有增加padding的bug，具体原因不明","http://img8.zol.com.cn/bbs/upload/19012/19011501_1000.jpg",
                new User("用户","http://sudasuta.com/wp-content/uploads/2015/10/nogame-nolife-1.jpg")));

        itemList.add(new ContentModel(3,"测试用]\n 我在测试换行以及换行后会不会有省略号...\n 我在测试换行以及换行后",
                "https://sjbz-fd.zol-img.com.cn/t_s320x510c/g5/M00/0F/0C/ChMkJlfJRMeIf8S0AATjBxjpX_UAAU8MwDLxokABOMf390.jpg",
                new User("用户","https://cache.cswsadlab.com/wp-content/uploads/2015/02/NGNL.jpg")));
        itemList.add(new ContentModel(4,"测试用]","https://ddnavi.com/wp-content/uploads/2014/04/02.jpg",
                new User("用户","https://ddnavi.com/wp-content/uploads/2014/04/02.jpg")));
    }

    @Override
    protected void initData() {

    }

    public void updateData(String tab){

        if (CommonUtils.isDebug){
            makeFakeData();
            callback.onDataLoaded(BaseCallback.CODE_OK);
        }else {
            //TODO 根据tab请求列表内容
//            callback.onDataLoaded();


        }
    }

    public List<ContentModel> getItemList() {
        return itemList;
    }
}
