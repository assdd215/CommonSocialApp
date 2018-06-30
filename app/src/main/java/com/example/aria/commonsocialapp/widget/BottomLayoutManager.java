package com.example.aria.commonsocialapp.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.activity.PublishActivity;
import com.example.aria.commonsocialapp.utils.CommonUtils;


//TODO 这里暂时先写死
public class BottomLayoutManager {

    TextView[] tv_pages;
    ImageView img_add;
    private Context context;

    private LinearLayout bottomLayout;
    private OnBottomItemClickListener itemClickListener;

    public BottomLayoutManager(LinearLayout bottomLayout){
        this.bottomLayout = bottomLayout;
        context = bottomLayout.getContext();
        initData();
    }

    private void initData(){
        tv_pages = new TextView[4];
        tv_pages[0] = bottomLayout.findViewById(R.id.tv_page1);
        tv_pages[1] = bottomLayout.findViewById(R.id.tv_page2);
        tv_pages[2] = bottomLayout.findViewById(R.id.tv_page3);
        tv_pages[3] = bottomLayout.findViewById(R.id.tv_page4);
        img_add = bottomLayout.findViewById(R.id.img_add);

        for (TextView tv:tv_pages){
            tv.setOnClickListener(onBottomItemClickListener);
        }

        img_add.setOnClickListener(onBottomItemClickListener);
    }

    private View.OnClickListener onBottomItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int target_tv = -1;
            switch (v.getId()){
                case R.id.img_add:
                    context.startActivity(new Intent(context, PublishActivity.class));
                    return;

                case R.id.tv_page1:
                    target_tv = 0;
                    break;
                case R.id.tv_page2:
                    target_tv = 1;
                    break;
                case R.id.tv_page3:
                    target_tv = 2;
                    break;
                case R.id.tv_page4:
                    target_tv = 3;
                    break;
            }

            for (int i = 0;i < tv_pages.length;i++){
                TextView tv = tv_pages[i];
                int textColor = i == target_tv ? Color.BLACK : context.getResources().getColor(R.color.common_grey);
                tv.setTextColor(textColor);
            }

            itemClickListener.onItemClick(target_tv);
        }
    };

    public void setItemClickListener(OnBottomItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnBottomItemClickListener{
        void onItemClick(int pos);
    }

}
