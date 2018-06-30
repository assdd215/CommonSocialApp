package com.example.aria.commonsocialapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.utils.CommonUtils;
import com.example.aria.commonsocialapp.utils.GlideUtils;
import com.example.aria.commonsocialapp.utils.PicassoUtils;
import com.example.aria.commonsocialapp.utils.task.FetchPicTask;
import com.example.aria.commonsocialapp.utils.task.TaskCallback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class RedBookPicPagerAdapter extends PagerAdapter{
    private Context context;
    private List<String> itemList;
    private int[] imgHeights;
    private Target[] targets;
    private int screenWidth;
    private ViewPager pager;
    private int defaultheight;

    public RedBookPicPagerAdapter(Context context, ViewPager mPager, List<String> imgUris, int defaultHeight){
        this.context = context;
        defaultheight = defaultHeight;
        screenWidth = CommonUtils.getScreenWidth(context);
        itemList = imgUris;
        imgHeights = new int[itemList.size()];

//        targets = new Target[itemList.size()];
//        for (int pos = 0; pos < itemList.size(); pos++){
//            final int p = pos;
//            targets[pos] = new Target() {
//                @Override
//                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                    if (bitmap != null){
//                        float scale = bitmap.getHeight() / bitmap.getWidth();
//                        imgHeights[p] = (int) (scale * screenWidth);
//
//                    }
//                }
//
//                @Override
//                public void onBitmapFailed(Exception e, Drawable errorDrawable) {
//
//                }
//
//                @Override
//                public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//                }
//            };
//        }
        this.pager = mPager;
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == imgHeights.length - 1)
                    return;
                int height = (int) ((imgHeights[position] == 0 ? defaultheight : imgHeights[position])
                        * (1 - positionOffset) +
                        (imgHeights[position + 1] == 0 ? defaultheight : imgHeights[position + 1])
                                * positionOffset);
                ViewGroup.LayoutParams params = pager.getLayoutParams();
                params.height = height;
                pager.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ViewGroup.LayoutParams params = pager.getLayoutParams();
        params.height = defaultHeight;
        pager.setLayoutParams(params);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final ImageView view = (ImageView) LayoutInflater.from(context).inflate(R.layout.content_detail_img,container,false);

        GlideUtils.get().load(itemList.get(position)).into(new ImageViewTarget<Drawable>(view) {
            @Override
            protected void setResource(@Nullable Drawable resource) {
                if (resource != null){
                    float scale = (float) resource.getIntrinsicHeight() / resource.getIntrinsicWidth();
                    imgHeights[position] = (int) (scale * screenWidth);
                    view.setImageDrawable(resource);
                }else{
                    //TODO 测试发现每次该方法会被调用三次，处理数据为空需要找到更好的方案。
                }
            }
        });
//        FetchPicTask task = new FetchPicTask();
//        task.setCallback(new TaskCallback() {
//            @Override
//            public void onDataLoaded(Object object) {
//                Bitmap bitmap = (Bitmap) object;
//                if (bitmap != null){
//                    float scale = bitmap.getHeight() / bitmap.getWidth();
//                    imgHeights[position] = (int) (scale * screenWidth);
//                    view.setImageBitmap(bitmap);
//                }
//            }
//        });
//        task.execute(itemList.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
