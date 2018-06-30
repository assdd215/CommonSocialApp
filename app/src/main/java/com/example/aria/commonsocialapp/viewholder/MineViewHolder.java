package com.example.aria.commonsocialapp.viewholder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.aria.commonsocialapp.R;

public class MineViewHolder extends RecyclerView.ViewHolder{

    RelativeLayout root;
    ImageView icon;
    AppCompatTextView title;
    public MineViewHolder(View itemView) {
        super(itemView);
        root = itemView.findViewById(R.id.root);
        icon = itemView.findViewById(R.id.icon);
        title = itemView.findViewById(R.id.title);
    }

    public AppCompatTextView getTitle() {
        return title;
    }

    public ImageView getIcon() {
        return icon;
    }

    public RelativeLayout getRoot() {
        return root;
    }
}
