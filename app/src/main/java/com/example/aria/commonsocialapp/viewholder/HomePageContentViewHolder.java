package com.example.aria.commonsocialapp.viewholder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.aria.commonsocialapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomePageContentViewHolder extends RecyclerView.ViewHolder{

    private RelativeLayout root;
    private ImageView content;
    private CircleImageView avactor;
    private AppCompatTextView title;
    private AppCompatTextView nickName;

    public HomePageContentViewHolder(View itemView) {
        super(itemView);
        root = itemView.findViewById(R.id.root);
        content = itemView.findViewById(R.id.img_content);
        title = itemView.findViewById(R.id.title);
        avactor = itemView.findViewById(R.id.content_avactor);
        nickName = itemView.findViewById(R.id.nickName);
    }

    public RelativeLayout getRoot() {
        return root;
    }

    public AppCompatTextView getTitle() {
        return title;
    }

    public AppCompatTextView getNickName() {
        return nickName;
    }

    public CircleImageView getAvactor() {
        return avactor;
    }

    public ImageView getContent() {
        return content;
    }
}
