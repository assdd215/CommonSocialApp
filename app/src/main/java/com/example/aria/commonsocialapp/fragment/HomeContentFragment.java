package com.example.aria.commonsocialapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.activity.PageContentActivity;
import com.example.aria.commonsocialapp.adapter.CardContentAdapter;
import com.example.aria.commonsocialapp.adapter.OnItemClickListener;
import com.example.aria.commonsocialapp.base.BaseFragment;
import com.example.aria.commonsocialapp.presenter.BaseCallback;
import com.example.aria.commonsocialapp.presenter.HomePageContentPresenter;
import com.example.aria.commonsocialapp.utils.Constants;

import butterknife.BindView;

public class HomeContentFragment extends BaseFragment{

    @BindView(R.id.root)
    SwipeRefreshLayout root;
    @BindView(R.id.Container)
    RecyclerView Container;

    private CardContentAdapter adapter;
    private HomePageContentPresenter presenter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    private String selectedTab;
    @Override
    protected void initData() {
        if (getArguments() != null){
            selectedTab = getArguments().getString(Constants.KEY_TAB);

            presenter = new HomePageContentPresenter(getContext(), new BaseCallback() {
                @Override
                public void onDataLoaded(int code) {

                    root.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            root.setRefreshing(false);
                        }
                    },1000);
                    //TODO 这是加载成功的情况
                    if (code == CODE_OK){
                        if (adapter == null){
                            adapter = new CardContentAdapter(getContext(),presenter.getItemList());
                            adapter.setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    Intent intent = new Intent(getContext(), PageContentActivity.class);
                                    intent.putExtra(Constants.KEY_PAGEID,presenter.getItemList().get(pos).getId());
                                    startActivity(intent);
                                }
                            });
                            staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
                            Container.setAdapter(adapter);
                            Container.setLayoutManager(staggeredGridLayoutManager);
                        }else
                            adapter.notifyDataSetChanged();
                    }
                }
            });

            root.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    presenter.updateData(selectedTab);
                }
            });
            presenter.updateData(selectedTab);

        }else {
            Log.d(TAG,"getArguments is null");
        }


    }

    public static HomeContentFragment newInstance(String tab){
        HomeContentFragment fragment = new HomeContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_TAB,tab);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_content;
    }
}
