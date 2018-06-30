package com.example.aria.commonsocialapp.utils;

import android.content.Context;

import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PicassoUtils {
    private static Picasso picasso;

    public static void init(Context context){
        Picasso.Builder builder = new Picasso.Builder(context);
        ExecutorService service = Executors.newFixedThreadPool(9);
        builder.executor(service);

        picasso = builder.build();

    }

    public static Picasso get() {
        return picasso;
    }
}
