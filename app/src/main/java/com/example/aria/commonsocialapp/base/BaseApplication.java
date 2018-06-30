package com.example.aria.commonsocialapp.base;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.aria.commonsocialapp.model.User;
import com.example.aria.commonsocialapp.utils.CommonUtils;
import com.example.aria.commonsocialapp.utils.GlideUtils;
import com.example.aria.commonsocialapp.utils.PicassoUtils;
import com.yuyh.library.imgsel.ISNav;
import com.yuyh.library.imgsel.common.ImageLoader;

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        ISNav.getInstance().init(new ImageLoader() {
            @Override
            public void displayImage(Context context, String path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });

        initUser();
        PicassoUtils.init(this);
        GlideUtils.init(this);
    }

    private void initUser(){
        //TODO 如果是以前登录的用户且token未过期，这里取出本地的用户信息后发往服务器验证用户账号密码是否合法后判断是否初始化
        if (CommonUtils.isDebug){
            User user = new User("蕾姆",
                    "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg");
            UserUtils.initUser(user);
        }
    }
}
