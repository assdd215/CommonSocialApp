package com.example.aria.commonsocialapp.viewholder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.aria.commonsocialapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentCommentViewHolder extends RecyclerView.ViewHolder{

    private CircleImageView avatar;
    private AppCompatTextView nickName;
    private AppCompatTextView comment;
    private AppCompatTextView time;
    private AppCompatTextView reply;
    private RelativeLayout root;

    public CircleImageView getAvatar() {
        return avatar;
    }

    public AppCompatTextView getNickName() {
        return nickName;
    }

    public AppCompatTextView getComment() {
        return comment;
    }

    public AppCompatTextView getTime() {
        return time;
    }

    public AppCompatTextView getReply() {
        return reply;
    }

    public RelativeLayout getRoot() {
        return root;
    }

    public ContentCommentViewHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        nickName = itemView.findViewById(R.id.nickname);
        comment = itemView.findViewById(R.id.comment);
        time = itemView.findViewById(R.id.time);
        reply = itemView.findViewById(R.id.reply);
        root = itemView.findViewById(R.id.root);

    }
}
