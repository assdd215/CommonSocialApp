package com.example.aria.commonsocialapp.utils.task;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class FetchPicTask extends AsyncTask<Object,Object,Bitmap>{

    private TaskCallback callback;

    @Override
    protected Bitmap doInBackground(Object... objects) {
        Log.d("MainActivity","doInBackground:" + objects[0].toString());
        Bitmap bitmap = null;
        String url = (String) objects[0];
        try {
            bitmap = Picasso.get().load(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.d("MainActivity","onPostExecute");
        super.onPostExecute(bitmap);
        callback.onDataLoaded(bitmap);
    }

    public void setCallback(TaskCallback callback) {
        this.callback = callback;
    }
}
