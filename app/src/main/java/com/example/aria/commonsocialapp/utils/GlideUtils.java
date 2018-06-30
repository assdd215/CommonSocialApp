package com.example.aria.commonsocialapp.utils;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {
    private static RequestManager manager;

    public static void init(Context context){
        manager = Glide.with(context).applyDefaultRequestOptions(new RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC));

    }

    public static RequestManager get(){
        return manager;
    }
}
