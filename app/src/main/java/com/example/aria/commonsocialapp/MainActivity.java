package com.example.aria.commonsocialapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aria.commonsocialapp.utils.CommonUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.yuyh.library.imgsel.ISNav;
import com.yuyh.library.imgsel.common.ImageLoader;
import com.yuyh.library.imgsel.config.ISListConfig;
import com.yuyh.library.imgsel.ui.ISListActivity;
import com.yuyh.library.imgsel.ui.fragment.ImgSelFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Picasso.get().load("http://f.hiphotos.baidu.com/zhidao/pic/item/3b87e950352ac65cbdbeff61fcf2b21193138a6d.jpg").into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                float scale =(float) bitmap.getHeight() / bitmap.getWidth();
                int defaultHeight = (int) (scale * CommonUtils.getScreenWidth(MainActivity.this));
                initViewPager(defaultHeight);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
    }


    private void initViewPager(int defaultHeight){
        PicPagerAdapter adapter = new PicPagerAdapter(this,pager,null,defaultHeight);
        pager.setAdapter(adapter);

    }
}

class PicPagerAdapter extends PagerAdapter{

    private Context context;
    private List<String> itemList;
    private int[] imgHeights;
    private int screenWidth;
    private ViewPager pager;
    private int defaultheight;

    public PicPagerAdapter(Context context, ViewPager mPager, List<Integer> items, int defaultHeight){
        this.context = context;
        defaultheight = defaultHeight;
        screenWidth = CommonUtils.getScreenWidth(context);
        itemList = new ArrayList<>();
        itemList.add("http://f.hiphotos.baidu.com/zhidao/pic/item/3b87e950352ac65cbdbeff61fcf2b21193138a6d.jpg");
        itemList.add("http://c.hiphotos.baidu.com/zhidao/pic/item/562c11dfa9ec8a1359aa88b6f103918fa0ecc030.jpg");
//        itemList.add("http://f.hiphotos.baidu.com/zhidao/pic/item/3b87e950352ac65cbdbeff61fcf2b21193138a6d.jpg");

        imgHeights = new int[itemList.size()];
        this.pager = mPager;
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == imgHeights.length - 1)
                    return;

                int height = (int) ((imgHeights[position] == 0 ? defaultheight : imgHeights[position]) * (1 - positionOffset) +
                                        (imgHeights[position + 1] == 0 ? defaultheight : imgHeights[position + 1]) * positionOffset);
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
        Picasso.get().load(itemList.get(position)).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                if (bitmap != null ){
                    float scale = (float) bitmap.getHeight() / bitmap.getWidth();
                    imgHeights[position] = (int) (scale * screenWidth);
                    view.setImageBitmap(bitmap);
                }else {
                    Toast.makeText(context,"img is null"+ position,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });
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
