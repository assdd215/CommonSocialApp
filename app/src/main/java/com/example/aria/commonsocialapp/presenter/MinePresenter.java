package com.example.aria.commonsocialapp.presenter;

import android.content.Context;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BasePresenter;
import com.example.aria.commonsocialapp.model.MenuItem;
import com.example.aria.commonsocialapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class MinePresenter extends BasePresenter{

    private List<MenuItem> menuList;
    private User user;

    public MinePresenter(Context context){
        super(context);
        makeFakeData();

    }

    @Override
    protected void makeFakeData() {
        menuList = new ArrayList<>();
        menuList.add(new MenuItem(R.drawable.ic_publish, R.string.mine_menu_publish));
        menuList.add(new MenuItem(R.drawable.ic_attention,R.string.mine_menu_attention));
        menuList.add(new MenuItem(R.drawable.ic_collection,R.string.mine_menu_collection));
        menuList.add(new MenuItem(R.drawable.ic_about_us,R.string.mine_menu_about));
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    @Override
    protected void initData() {

    }


}
