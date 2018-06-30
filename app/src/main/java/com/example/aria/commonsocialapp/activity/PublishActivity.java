package com.example.aria.commonsocialapp.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.adapter.PublishImgAdapter;
import com.example.aria.commonsocialapp.base.BaseActivity;
import com.example.aria.commonsocialapp.presenter.BaseCallback;
import com.example.aria.commonsocialapp.presenter.PublishPresenter;
import com.yuyh.library.imgsel.ui.ISListActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class PublishActivity extends BaseActivity{

    public static final int TO_IS_REQUEST_CODE = 1;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pic_Container)
    RecyclerView picContainer;

    private PublishPresenter presenter;
    private PublishImgAdapter adapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void initData() {
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublishActivity.this.finish();
            }
        });

        presenter = new PublishPresenter(this, new BaseCallback() {
            @Override
            public void onDataLoaded(int code) {
                if (code == BaseCallback.CODE_OK){
                    if (adapter == null){
                        adapter = new PublishImgAdapter(PublishActivity.this,presenter.getItemList());
                        picContainer.setAdapter(adapter);
                        gridLayoutManager = new GridLayoutManager(PublishActivity.this,4);
                        picContainer.setLayoutManager(gridLayoutManager);
                    }
                    else {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        presenter.updateData();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_publish;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case TO_IS_REQUEST_CODE:
                if (data != null)
                    presenter.updateData(data.getStringArrayListExtra(ISListActivity.INTENT_RESULT));
                else
                    presenter.updateData();

        }
    }
}
