package com.example.aria.commonsocialapp.model;

import java.util.List;

public class PageContentModel {

    private int id;
    private List<String> imgUrls;
    private String contentText;
    private User user;
    int commentNum;
    int collectNum;
    int likeNum;
    String time;

    public PageContentModel(List<String> imgUrls, String contentText, User user) {
        this.imgUrls = imgUrls;
        this.contentText = contentText;
        this.user = user;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public String getContentText() {
        return contentText;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public PageContentModel(int id, List<String> imgUrls, String contentText, User user, int commentNum, int collectNum, int likeNum, String time) {
        this.id = id;
        this.imgUrls = imgUrls;
        this.contentText = contentText;
        this.user = user;
        this.commentNum = commentNum;
        this.collectNum = collectNum;
        this.likeNum = likeNum;
        this.time = time;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public String getTime() {
        return time;
    }
}
