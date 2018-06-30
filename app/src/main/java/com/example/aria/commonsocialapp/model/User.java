package com.example.aria.commonsocialapp.model;

public class User {
    private int id;
    private String nickName;
    private String avactorUrl;

    public User(String nickName, String avactorUrl) {
        this.nickName = nickName;
        this.avactorUrl = avactorUrl;
    }

    public int getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvactorUrl() {
        return avactorUrl;
    }
}
