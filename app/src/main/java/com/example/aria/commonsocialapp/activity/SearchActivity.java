package com.example.aria.commonsocialapp.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity{

    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.et_search)
    EditText etSearch;
    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_cancel})
    void onClick(View view){
        switch (view.getId()){
            case R.id.tv_cancel:
                finish();
                break;
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_search;
    }
}
