package com.example.aria.commonsocialapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BaseRecAdapter;
import com.example.aria.commonsocialapp.model.CommentModel;
import com.example.aria.commonsocialapp.utils.PicassoUtils;
import com.example.aria.commonsocialapp.viewholder.ContentCommentViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContentCommentAdapter extends BaseRecAdapter<CommentModel,ContentCommentViewHolder>{

    private OnCommentClickListener onItemClickListener;


    public ContentCommentAdapter(Context context, List<CommentModel> itemList) {
        super(context, itemList);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected ContentCommentViewHolder createHoleder(ViewGroup parent, int viewType) {
        return new ContentCommentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_comment,parent,false));
    }

    @Override
    protected void bindViews(ContentCommentViewHolder holder, final int pos) {
        CommentModel model = itemList.get(pos);
        PicassoUtils.get().load(model.getUser().getAvactorUrl()).into(holder.getAvatar());
        holder.getNickName().setText(model.getUser().getNickName());
        holder.getComment().setText(model.getCommentContent());
        holder.getTime().setText(model.getTime());
        holder.getReply().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onReplyClick(v,pos);
            }
        });
        holder.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v,pos);
            }
        });
    }

    public void setOnItemClickListener(OnCommentClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnCommentClickListener extends OnItemClickListener{
        void onReplyClick(View view,int pos);
    }
}
