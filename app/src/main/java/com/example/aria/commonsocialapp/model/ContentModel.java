package com.example.aria.commonsocialapp.model;

public class ContentModel {

    int id;
    String title;
    String imgUrl;
    User user;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getNickName() {
        return user.getNickName();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public User getUser() {
        return user;
    }

    public ContentModel(int id, String title, String imgUrl, User user) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.user = user;
    }
}
