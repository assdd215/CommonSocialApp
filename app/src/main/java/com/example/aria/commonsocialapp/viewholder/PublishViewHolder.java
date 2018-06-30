package com.example.aria.commonsocialapp.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class PublishViewHolder extends RecyclerView.ViewHolder{

    ImageView img;

    public PublishViewHolder(View itemView) {
        super(itemView);
        img = (ImageView) itemView;
    }

    public ImageView getImg() {
        return img;
    }
}
