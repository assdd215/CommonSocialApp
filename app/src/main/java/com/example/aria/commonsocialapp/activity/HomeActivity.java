package com.example.aria.commonsocialapp.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BaseActivity;
import com.example.aria.commonsocialapp.base.BaseFragment;
import com.example.aria.commonsocialapp.fragment.EmptyFragment;
import com.example.aria.commonsocialapp.fragment.HomeFragment;
import com.example.aria.commonsocialapp.fragment.MineFragment;
import com.example.aria.commonsocialapp.widget.BottomLayoutManager;

import butterknife.BindView;

public class HomeActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.Container)
    FrameLayout Container;
    @BindView(R.id.bottom_ll)
    LinearLayout bottomLayout;
    @BindView(R.id.toolbar_title)
    AppCompatTextView toolbarTitle;
    BottomLayoutManager bottomLayoutManager;

    private HomeFragment homeFragment;
    private EmptyFragment emptyFragment;
    private MineFragment mineFragment;
    private BaseFragment currentFragment = null;

    @Override
    protected void initData() {

        //初始化toolbar
        setSupportActionBar(toolbar);

        //初始化Fragment
        if (currentFragment == null){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            homeFragment= new HomeFragment();
            currentFragment = homeFragment;
            transaction.add(R.id.Container,currentFragment);
            transaction.commit();
        }


        bottomLayoutManager = new BottomLayoutManager(bottomLayout);
        bottomLayoutManager.setItemClickListener(new BottomLayoutManager.OnBottomItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                BaseFragment toFragment;
                switch (pos){
                    case 0:
                        if (homeFragment == null){
                            homeFragment = new HomeFragment();
                        }
                        toFragment = homeFragment;
                        break;
                    case 3:
                        if (mineFragment == null){
                            mineFragment = new MineFragment();
                        }
                        toFragment = mineFragment;
                        break;
                    case 1:
                    case 2:
                    default:
                        setTitleByPos(pos);
                        if (currentFragment instanceof EmptyFragment)
                            return;
                        if (emptyFragment == null){
                            emptyFragment = new EmptyFragment();
                        }
                        toFragment = emptyFragment;
                        break;
                }
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (currentFragment != null)
                    ft.hide(currentFragment);

                if (!toFragment.isAdded())
                    ft.add(R.id.Container,toFragment).commit();
                else
                    ft.show(toFragment).commit();
                currentFragment = toFragment;
                setTitleByPos(pos);
            }
        });
    }

    private void setTitleByPos(int pos){
        int titleId = -1;
        switch (pos){
            case 0:
                titleId = R.string.bottom_menu_first_page;
                break;
            case 1:
                titleId = R.string.bottom_menu_mall;
                break;
            case 2:
                titleId = R.string.bottom_menu_message;
                break;
            case 3:
                titleId = R.string.bottom_menu_me;
                break;
            default:
                toolbarTitle.setText("空");
                return;
        }
        toolbarTitle.setText(titleId);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_home;
    }
}
