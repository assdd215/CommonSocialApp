package com.example.aria.commonsocialapp.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.request.target.ImageViewTarget;
import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.adapter.ContentCommentAdapter;
import com.example.aria.commonsocialapp.adapter.RedBookPicPagerAdapter;
import com.example.aria.commonsocialapp.base.BaseActivity;
import com.example.aria.commonsocialapp.model.User;
import com.example.aria.commonsocialapp.presenter.PageContentPresenter;
import com.example.aria.commonsocialapp.utils.CommonUtils;
import com.example.aria.commonsocialapp.utils.Constants;
import com.example.aria.commonsocialapp.utils.GlideUtils;
import com.example.aria.commonsocialapp.utils.PicassoUtils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class PageContentActivity extends BaseActivity{

    private static final int CODE_INIT_VIEW = 1;

    @BindView(R.id.picPager)
    ViewPager picPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pagerToolbar)
    Toolbar pagerToolbar;
    @BindView(R.id.toolbar_nickname)
    AppCompatTextView toolbarNickname;
    @BindView(R.id.toolbar_avatar)
    CircleImageView toolbarAvatar;
    @BindView(R.id.toolbar_content)
    RelativeLayout toolbar_content;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.pic_page_indicator)
    AppCompatTextView picIndicator;
    @BindView(R.id.ll_introduce)
    RelativeLayout introduceLayout;
    @BindView(R.id.avatar_introduce)
    CircleImageView introduceAvatar;
    @BindView(R.id.tv_introduce_nickname)
    AppCompatTextView introduceNickname;
    @BindView(R.id.btn_attention)
    AppCompatButton attentionBtn;
    @BindView(R.id.tv_content)
    AppCompatTextView contentText;
    @BindView(R.id.ll_comment_head)
    RelativeLayout commentHeadLayout;
    @BindView(R.id.tv_comment_num)
    AppCompatTextView tvCommentNum;
    @BindView(R.id.ll_express_comment)
    RelativeLayout expressCommentLayout;
    @BindView(R.id.avatar_express_comment)
    CircleImageView expressCommentAvatar;
    @BindView(R.id.tv_express_comment)
    AppCompatTextView tvExpressComment;
    @BindView(R.id.comment_container)
    RecyclerView commentContainer;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @BindView(R.id.view_comment_blank)
    View blankView;
    @BindView(R.id.et_edit_comment)
    AppCompatEditText etEditComment;
    @BindView(R.id.ll_reply_comment)
    RelativeLayout replyCommentLayout;
    @BindView(R.id.btn_send_comment)
    AppCompatButton btnSendReply;


    private PageContentPresenter presenter;
    private RedBookPicPagerAdapter pagerAdapter;
    private ContentCommentAdapter commentAdapter;
    private LinearLayoutManager commentLayoutManager;
    private Animator toolbar_animation;
    private boolean preState = true;
    private boolean isFirstAnim = true;

    //TODO 查文档发现 target是弱引用 容易被GC导致接收不到回调，于是需要将它保存起来
    private Target getAvatarTarget = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap avatar, Picasso.LoadedFrom from) {
            Log.d("MainActivity","onBitmapLoaded");
            toolbarAvatar.setImageBitmap(avatar);
            expressCommentAvatar.setImageBitmap(avatar);
            introduceAvatar.setImageBitmap(avatar);
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            Log.d("MainActivity","onBitmapFailed");
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            Log.d("MainActivity","onPrepareLoad");
        }
    };
    private Target getFirstImgTarget = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

            float scale =(float) bitmap.getHeight() / bitmap.getWidth();
            int defaultHeight = (int) (scale * CommonUtils.getScreenWidth(PageContentActivity.this));
            pagerAdapter = new RedBookPicPagerAdapter(PageContentActivity.this,picPager,presenter.getImgUris(),defaultHeight);
            picPager.setAdapter(pagerAdapter);
            picPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    picIndicator.setText(getString(R.string.content_pic_indicator,position + 1,presenter.getImgUris().size()));
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };



    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case CODE_INIT_VIEW:
                    initView();
                    break;
            }
        }
    };

    @Override
    protected void initData() {

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageContentActivity.this.finish();
            }
        });
        pagerToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PageContentActivity.this.finish();
            }
        });
        attentionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attentionToUser();
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int deltaHeight = appBarLayout.getHeight() - toolbar.getHeight();
                int delta = deltaHeight + verticalOffset;
                if (delta == 0) //TODO 已到顶端
                    executeToolbarTitleAnim(false);
                if (delta == deltaHeight) //TODO 说明已到底端
                    executeToolbarTitleAnim(true);
            }
        });
        blankView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blankView.setVisibility(View.GONE);
                replyCommentLayout.setVisibility(View.GONE);
                etEditComment.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etEditComment.getWindowToken(), 0); //强制隐藏键盘
            }
        });
        etEditComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s == null || s.length() == 0){
                    btnSendReply.setEnabled(false);
                }else
                    btnSendReply.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnSendReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PageContentActivity.this,"text:" + etEditComment.getText().toString(),Toast.LENGTH_SHORT).show();
                blankView.performClick();
            }
        });

        expressCommentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replyCommentLayout.setVisibility(View.VISIBLE);
                blankView.setVisibility(View.VISIBLE);
                etEditComment.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(etEditComment,InputMethodManager.SHOW_FORCED);
//                imm.showSoftInput(,InputMethodManager.SHOW_FORCED);
            }
        });


        presenter = new PageContentPresenter(this);
        presenter.setCallback(new PageContentPresenter.PageContentCallback() {
            @Override
            public void onImgUriLoaded(int code) {
                Picasso.get().load(presenter.getImgUris().get(0)).into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        float scale =(float) bitmap.getHeight() / bitmap.getWidth();
                        int defaultHeight = (int) (scale * CommonUtils.getScreenWidth(PageContentActivity.this));
                        pagerAdapter = new RedBookPicPagerAdapter(PageContentActivity.this,picPager,presenter.getImgUris(),defaultHeight);
                        picPager.setAdapter(pagerAdapter);
                        picPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                            }

                            @Override
                            public void onPageSelected(int position) {
                                picIndicator.setText(getString(R.string.content_pic_indicator,position + 1,presenter.getImgUris().size()));
                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {

                            }
                        });
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {

                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
            }

            @Override
            public void onPageDataLoaded(int code) {
                if (code == CODE_OK){
                    //TODO 缓存图片
                    for (String imgUrl : presenter.getImgUris()){
                        GlideUtils.get().load(imgUrl).preload();
                    }
                    handler.sendMessageDelayed(handler.obtainMessage(CODE_INIT_VIEW),500);
                }
            }

            @Override
            public void onCommentsLoaded(int code) {
                if (code == CODE_OK){
                    if (commentAdapter == null){
                        commentAdapter = new ContentCommentAdapter(PageContentActivity.this,presenter.getCommentList());
                        commentAdapter.setOnItemClickListener(new ContentCommentAdapter.OnCommentClickListener() {
                            @Override
                            public void onReplyClick(View view, int pos) {
                                Toast.makeText(PageContentActivity.this,"回复功能尚未完善",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(View view, int pos) {
                                Toast.makeText(PageContentActivity.this,"该功能尚未完善",Toast.LENGTH_SHORT).show();

                            }
                        });
                        commentLayoutManager = new LinearLayoutManager(PageContentActivity.this);
                        commentContainer.setAdapter(commentAdapter);
                        commentContainer.setLayoutManager(commentLayoutManager);
                    }

                    commentAdapter.notifyDataSetChanged();

                }
            }
        });
        int pageId = getIntent().getIntExtra(Constants.KEY_PAGEID,-1);
        presenter.loadPageData(pageId);
        presenter.loadComment(pageId,1);

    }

    private void attentionToUser(){
        Toast.makeText(this,"该功能尚未实现",Toast.LENGTH_SHORT).show();
    }

    private void initView(){
        progressBar.setVisibility(View.GONE);
        PicassoUtils.get().load(presenter.getImgUris().get(0)).into(getFirstImgTarget);

        User user = presenter.getUser();
        PicassoUtils.get().load(user.getAvactorUrl()).placeholder(R.color.white).into(getAvatarTarget);
        toolbarNickname.setText(user.getNickName());
        introduceNickname.setText(user.getNickName());
        setPassageContent();
        setExpressCommentText();

    }

    private void setPassageContent(){
        contentText.setText(presenter.getContentText());
        // 后面补充设置时间和收藏数和点赞数
    }

    private void setExpressCommentText(){
//        tvExpressComment.setText("");
        tvCommentNum.setText(getString(R.string.content_comment_num,presenter.getCommentNum()));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_content_detail;
    }

    private void executeToolbarTitleAnim(boolean isExpand){
        if (isFirstAnim){
            isFirstAnim = false; // 阻止第一次动画的执行
            return;
        }

        if (preState == isExpand)
            return;

        if (toolbar_animation != null){
            toolbar_animation.cancel();
            toolbar_animation = null;
        }

        toolbar_animation = AnimatorInflater.loadAnimator(this,isExpand ? R.animator.to_transparent : R.animator.from_transparent);
        toolbar_animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                toolbar_animation = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        toolbar_animation.setTarget(toolbar);
        toolbar_animation.start();
        preState = isExpand;

    }
}
