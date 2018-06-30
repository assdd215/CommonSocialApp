package com.example.aria.commonsocialapp.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public abstract class BasePagerAdapter<T> extends FragmentStatePagerAdapter{

    protected List<T> itemList;
    protected Context context;

    public BasePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        initData();
    }

    protected abstract void initData();

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return getTitle(position);
    }

    protected abstract String getTitle(int pos);
}
