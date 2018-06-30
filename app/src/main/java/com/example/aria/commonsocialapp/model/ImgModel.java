package com.example.aria.commonsocialapp.model;

public class ImgModel {

    public static final int TYPE_IMG = 0;
    public static final int TYPE_ADD = 1;

    private int type;
    private String imgUri;

    public ImgModel(String imgUri){
        this.imgUri = imgUri;
        type = TYPE_IMG;
    }

    public int getType() {
        return type;
    }

    public String getImgUri() {
        return imgUri;
    }

    public ImgModel(String imgUri, int type){
        this.imgUri = imgUri;
        this.type = type;

    }
}
