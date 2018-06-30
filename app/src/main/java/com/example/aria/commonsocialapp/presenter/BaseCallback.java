package com.example.aria.commonsocialapp.presenter;

public interface BaseCallback {

    int CODE_OK = 200;
    int CODE_EMPTY = 404;

    void onDataLoaded(int code);
}
