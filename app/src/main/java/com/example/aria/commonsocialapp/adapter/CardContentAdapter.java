package com.example.aria.commonsocialapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BaseRecAdapter;
import com.example.aria.commonsocialapp.model.ContentModel;
import com.example.aria.commonsocialapp.utils.PicassoUtils;
import com.example.aria.commonsocialapp.viewholder.HomePageContentViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardContentAdapter extends BaseRecAdapter<ContentModel,HomePageContentViewHolder> {

    private OnItemClickListener onItemClickListener;

    public CardContentAdapter(Context context, List<ContentModel> itemList) {
        super(context,itemList);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected HomePageContentViewHolder createHoleder(ViewGroup parent, int viewType) {

        return new HomePageContentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_content,parent,false));
    }

    @Override
    protected void bindViews(HomePageContentViewHolder holder, final int pos) {
        ContentModel model = itemList.get(pos);
        holder.getTitle().setText(model.getTitle());

        PicassoUtils.get()
                .load(model.getImgUrl())
                .placeholder(R.color.white)
                .into(holder.getContent());
        PicassoUtils.get()
                .load(model.getUser().getAvactorUrl())
                .placeholder(R.color.white)
                .into(holder.getAvactor());
        holder.getNickName().setText(model.getNickName());

        holder.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v,pos);
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
