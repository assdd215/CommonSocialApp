package com.example.aria.commonsocialapp.base;

import com.example.aria.commonsocialapp.model.User;

public class UserUtils {

    static User user;

    public static User getUser() {
        return user;
    }

    static void initUser(User user){
        UserUtils.user = user;
    }

    public static boolean isLogin(){
        return user == null;
    }

    public static void logout(){
        user = null;
        //TODO 这里需要补充清空本地user信息的操作
    }

    public static String getAvatarUrl(){
        return user == null ? null : user.getAvactorUrl();
    }

    public static String getNickName(){
        return user == null ? null : user.getNickName();
    }

}
