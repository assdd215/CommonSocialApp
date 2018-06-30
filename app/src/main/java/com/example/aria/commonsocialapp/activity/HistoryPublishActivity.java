package com.example.aria.commonsocialapp.activity;

import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.adapter.CardContentAdapter;
import com.example.aria.commonsocialapp.adapter.OnItemClickListener;
import com.example.aria.commonsocialapp.base.BaseActivity;
import com.example.aria.commonsocialapp.base.UserUtils;
import com.example.aria.commonsocialapp.presenter.BaseCallback;
import com.example.aria.commonsocialapp.presenter.HistoryPublishPresenter;
import com.example.aria.commonsocialapp.utils.Constants;
import com.example.aria.commonsocialapp.utils.PicassoUtils;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class HistoryPublishActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.Container)
    RecyclerView Container;
    @BindView(R.id.toolbar_nickname)
    AppCompatTextView toolbarNickName;
    @BindView(R.id.toolbar_avatar)
    CircleImageView toolbarAvatar;


    private HistoryPublishPresenter presenter;
    private CardContentAdapter adapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void initData() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoryPublishActivity.this.finish();
            }
        });

        presenter = new HistoryPublishPresenter(this);
        presenter.setCallback(new BaseCallback() {
            @Override
            public void onDataLoaded(int code) {
                if (adapter == null){
                    adapter = new CardContentAdapter(HistoryPublishActivity.this,presenter.getItemList());
                    adapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int pos) {
                            Intent intent = new Intent(HistoryPublishActivity.this, PageContentActivity.class);
                            intent.putExtra(Constants.KEY_PAGEID,presenter.getItemList().get(pos).getId());
                            startActivity(intent);
                        }
                    });
                    Container.setAdapter(adapter);
                    staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
                    Container.setLayoutManager(staggeredGridLayoutManager);
                }
                adapter.notifyDataSetChanged();
            }
        });

        PicassoUtils.get().load(UserUtils.getAvatarUrl()).into(toolbarAvatar);
        toolbarNickName.setText(UserUtils.getNickName());


        presenter.loadData(0);


    }

    @Override
    protected int layoutId() {
        return R.layout.activity_history_publish;
    }
}
