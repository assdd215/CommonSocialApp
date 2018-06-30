package com.example.aria.commonsocialapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BasePagerAdapter;
import com.example.aria.commonsocialapp.fragment.EmptyFragment;
import com.example.aria.commonsocialapp.fragment.HomeContentFragment;

import java.util.List;

public class HomePagerAdapter extends BasePagerAdapter<String> {

    public static final String RECOMMEND = "推荐";

    public HomePagerAdapter(FragmentManager fm, Context context, List<String> itemList) {
        super(fm,context);
        this.itemList = itemList;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected String getTitle(int pos) {
        return itemList.get(pos);
    }

    @Override
    public Fragment getItem(int position) {

        String item = itemList.get(position);
        if (TextUtils.equals(context.getString(R.string.home_tab_recommend),item)){
            return HomeContentFragment.newInstance(itemList.get(position));
        }else
            return new EmptyFragment();
    }
}
