package com.example.aria.commonsocialapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.activity.PublishActivity;
import com.example.aria.commonsocialapp.base.BaseRecAdapter;
import com.example.aria.commonsocialapp.model.ImgModel;
import com.example.aria.commonsocialapp.viewholder.PublishViewHolder;
import com.yuyh.library.imgsel.ISNav;
import com.yuyh.library.imgsel.config.ISListConfig;

import java.util.List;

public class PublishImgAdapter extends BaseRecAdapter<ImgModel,PublishViewHolder> {

    public PublishImgAdapter(Context context, List<ImgModel> itemList) {
        super(context, itemList);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected PublishViewHolder createHoleder(ViewGroup parent, int viewType) {
        return new PublishViewHolder(LayoutInflater.from(context).inflate(R.layout.item_thumbnail,parent,false));
    }

    @Override
    protected void bindViews(PublishViewHolder holder, int pos) {

        ImgModel model = itemList.get(pos);
        switch (model.getType()){
            case ImgModel.TYPE_IMG:
                Glide.with(context)
                        .load(model.getImgUri())
                        .into(holder.getImg());
                holder.getImg().setBackgroundColor(Color.TRANSPARENT);
                break;

            case ImgModel.TYPE_ADD:
                holder.getImg().setImageResource(R.drawable.img_publish_add);
                holder.getImg().setBackgroundResource(R.drawable.fragment_publish_btn_add_bg);
                break;
        }
        holder.getImg().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ISListConfig config = new ISListConfig.Builder()
                        .statusBarColor(Color.DKGRAY)
                        .titleColor(Color.WHITE)
                        .titleBgColor(Color.DKGRAY)
                        .btnTextColor(Color.WHITE)
                        .btnBgColor(Color.DKGRAY)
                        .cropSize(1,1,200,200)
                        .multiSelect(true)
                        .needCamera(true)
                        .maxNum(9)
                        .build();

                ISNav.getInstance().toListActivity(context,config, PublishActivity.TO_IS_REQUEST_CODE);
            }
        });
    }

    public void addItems(List<ImgModel> items){
        itemList.addAll(itemList.size() - 1,items);
    }


}
