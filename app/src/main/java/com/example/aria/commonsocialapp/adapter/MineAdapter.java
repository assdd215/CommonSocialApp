package com.example.aria.commonsocialapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BaseRecAdapter;
import com.example.aria.commonsocialapp.model.MenuItem;
import com.example.aria.commonsocialapp.viewholder.MineViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MineAdapter extends BaseRecAdapter<MenuItem,MineViewHolder> {


    public MineAdapter(Context context, List<MenuItem> itemList) {
        super(context,itemList);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MineViewHolder createHoleder(ViewGroup parent, int viewType) {
        return new MineViewHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_menu,parent,false));
    }


    @Override
    protected void bindViews(MineViewHolder holder,final int pos) {
        holder.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMenuItemClickListener.onItemClick(v,itemList.get(pos).getTitleId());
            }
        });

        holder.getIcon().setImageResource(itemList.get(pos).getIconId());
        holder.getTitle().setText(itemList.get(pos).getTitleId());
    }

    private OnMenuItemClickListener onMenuItemClickListener;

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.onMenuItemClickListener = onMenuItemClickListener;
    }

    public interface OnMenuItemClickListener {
        void onItemClick(View view,int titleId);
    }
}
