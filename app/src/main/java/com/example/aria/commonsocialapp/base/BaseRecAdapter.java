package com.example.aria.commonsocialapp.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseRecAdapter<D,H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H>{

    protected List<D> itemList;
    protected Context context;

    public BaseRecAdapter(Context context,List<D> itemList){
        this.context = context;
        this.itemList = itemList;
        initData();
    }

    protected abstract void initData();

    @NonNull
    @Override
    public H onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return createHoleder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull H holder, int position) {
        bindViews(holder,position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    protected abstract H createHoleder(ViewGroup parent,int viewType);

    protected abstract void bindViews(H holder,int pos);

    public void setItemList(List<D> itemList) {
        this.itemList = itemList;
    }
}
