package com.example.aria.commonsocialapp.model;

public class MenuItem {

    int iconId;
    int titleId;

    public MenuItem(int iconId,int titleId){
        this.iconId = iconId;
        this.titleId = titleId;
    }

    public int getIconId() {
        return iconId;
    }

    public int getTitleId() {
        return titleId;
    }
}
