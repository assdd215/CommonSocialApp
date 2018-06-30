package com.example.aria.commonsocialapp.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.activity.SearchActivity;
import com.example.aria.commonsocialapp.adapter.HomePagerAdapter;
import com.example.aria.commonsocialapp.base.BaseFragment;
import com.example.aria.commonsocialapp.presenter.BaseCallback;
import com.example.aria.commonsocialapp.presenter.HomePagePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment{


    @BindView(R.id.pager_Container)
    ViewPager mPager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.tv_search)
    TextView mSearchBar;

    private HomePagerAdapter pagerAdapter;
    private HomePagePresenter pagePresenter;



    @Override
    protected void initData() {
        pagePresenter = new HomePagePresenter(getContext(), new BaseCallback() {
            @Override
            public void onDataLoaded(int code) {
                if (code == BaseCallback.CODE_OK){
                    if (pagerAdapter == null){
                        pagerAdapter = new HomePagerAdapter(getFragmentManager(),getContext(),pagePresenter.getTitleList());
                        mPager.setAdapter(pagerAdapter);
                        mTabLayout.setupWithViewPager(mPager);
                    }else
                        pagerAdapter.notifyDataSetChanged();
                }
            }
        });
        //TODO 这里可以加个progressBar，等请求道数据后就把bar去掉
        pagePresenter.updateTabData();
    }


    @OnClick({R.id.tv_search})
    void onClick(View view){
        switch (view.getId()){
            case R.id.tv_search:
                startActivity(new Intent(getContext(), SearchActivity.class));
        }
    }



    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }
}
