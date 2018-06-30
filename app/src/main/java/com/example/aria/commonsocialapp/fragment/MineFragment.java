package com.example.aria.commonsocialapp.fragment;

import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.activity.HistoryPublishActivity;
import com.example.aria.commonsocialapp.adapter.MineAdapter;
import com.example.aria.commonsocialapp.base.BaseFragment;
import com.example.aria.commonsocialapp.base.UserUtils;
import com.example.aria.commonsocialapp.presenter.MinePresenter;
import com.example.aria.commonsocialapp.utils.PicassoUtils;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MineFragment extends BaseFragment{

    @BindView(R.id.menu_Container)
    RecyclerView menuContainer;
    @BindView(R.id.avatar)
    CircleImageView avactor;
    @BindView(R.id.tv_nickname)
    AppCompatTextView tvNickname;

    private MineAdapter adapter;
    private MinePresenter presenter;

    @Override
    protected void initData() {
        presenter = new MinePresenter(getContext());
        adapter = new MineAdapter(getContext(),presenter.getMenuList());
        adapter.setOnMenuItemClickListener(new MineAdapter.OnMenuItemClickListener() {
            @Override
            public void onItemClick(View view, int titleId) {
                switch (titleId){
                    case R.string.mine_menu_publish:
                        Intent intent = new Intent(getContext(), HistoryPublishActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        menuContainer.setAdapter(adapter);
        menuContainer.setLayoutManager(new LinearLayoutManager(getContext()));

        PicassoUtils.get().load(UserUtils.getAvatarUrl()).into(avactor);
        tvNickname.setText(UserUtils.getNickName());
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_mine;
    }
}
