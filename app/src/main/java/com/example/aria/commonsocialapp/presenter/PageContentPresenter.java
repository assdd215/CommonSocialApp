package com.example.aria.commonsocialapp.presenter;

import android.content.Context;

import com.example.aria.commonsocialapp.R;
import com.example.aria.commonsocialapp.base.BasePresenter;
import com.example.aria.commonsocialapp.model.CommentModel;
import com.example.aria.commonsocialapp.model.PageContentModel;
import com.example.aria.commonsocialapp.model.User;
import com.example.aria.commonsocialapp.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class PageContentPresenter extends BasePresenter{

    private PageContentCallback callback;
    private PageContentModel pageContentModel;
    private List<String> imgUris;
    private List<CommentModel> commentList;


    public PageContentPresenter(Context context) {
        super(context);
    }

    @Override
    protected void makeFakeData() {
        imgUris = new ArrayList<>();
        imgUris.add("https://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=dc266d0cd958ccbf1be9bd3c29e89006/9213b07eca806538632f60ad9fdda144ac348243.jpg");
        imgUris.add("https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D450%2C600/sign=5dd542d03d2ac65c67506e77cec29e27/9f2f070828381f308e761319a1014c086e06f017.jpg");
        imgUris.add("https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=de8489450246f21fc9615655c6144758/cefc1e178a82b90143de048d7b8da9773912ef19.jpg");
        imgUris.add("https://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=780691a96ad0f703e6e79dda38ca7d05/d833c895d143ad4b2306817e8a025aafa40f0660.jpg");
        imgUris.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917848700&di=fba9c290cc370efc265312f3f11846dd&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F203fb80e7bec54e76d703294b1389b504ec26a9f.jpg");
        imgUris.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917848700&di=485e8e3994bf1ab9f2e56257b9b0123c&imgtype=0&src=http%3A%2F%2Fss.moemoe.la%2Fimage%2F2017-09-30%2Fae3673e2-cbb2-41bd-b47b-88cf84b351fa.png");
        imgUris.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917848699&di=dac8f7a0b7f65e9e380ea1eb28a54e0c&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2Fffc9a98655a5582010337822594e49636570ddb5.jpg");
        imgUris.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917848698&di=8dc13b5ef04d864dd7a5d7ffc33d5543&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2F071377953c4d64cf2db4087eeb0353151f6d7127.jpg");
        imgUris.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917848698&di=dfd73efb34cfcc3df498d58eb6e63444&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201608%2F30%2F20160830230008_fLGry.thumb.700_0.jpeg");

        User user = new User("蕾姆","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg");
        pageContentModel = new PageContentModel(1,imgUris,context.getString(R.string.large_text),user,50,50,50,"2018-6-25");
    }

    @Override
    protected void initData() {

    }

    public void loadImgUris(){
        if (CommonUtils.isDebug){
//            makeFakeData();
            callback.onImgUriLoaded(PageContentCallback.CODE_OK);
        }
    }

    public void loadPageData(int pageId){
        //TODO 需要处理pageId为-1  也就是为空的情况
        if (CommonUtils.isDebug){
            makeFakeData();
            callback.onPageDataLoaded(PageContentCallback.CODE_OK);
        }
    }

    public void loadComment(int pageId,int page){
        if (CommonUtils.isDebug){
            makeFakeComments();
            callback.onCommentsLoaded(PageContentCallback.CODE_OK);
        }
    }

    public void makeFakeComments(){
        commentList = new ArrayList<>();
        commentList.add(new CommentModel(new User("昵称1","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论1","6-25"));
        commentList.add(new CommentModel(new User("昵称2","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论2","6-25"));
        commentList.add(new CommentModel(new User("昵称3","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论3","6-25"));
        commentList.add(new CommentModel(new User("昵称1","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论1","6-25"));
        commentList.add(new CommentModel(new User("昵称2","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论2","6-25"));
        commentList.add(new CommentModel(new User("昵称3","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论3","6-25"));
        commentList.add(new CommentModel(new User("昵称1","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论1","6-25"));
        commentList.add(new CommentModel(new User("昵称2","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论2","6-25"));
        commentList.add(new CommentModel(new User("昵称3","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529917472353&di=fa10b88235a65c2922fc85638281c951&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Fface%2Fc3696b44abb8c40a15edef114436ae82c73723d6.jpg"),
                "这是评论3","6-25"));
    }

    public void setCallback(PageContentCallback callback) {
        this.callback = callback;
    }

    public List<String> getImgUris() {
        return pageContentModel.getImgUrls();
    }

    public User getUser(){
        return pageContentModel.getUser();
    }

    public String getContentText(){
        return pageContentModel.getContentText();
    }

    public int getCommentNum(){
        return pageContentModel.getCommentNum();
    }

    public List<CommentModel> getCommentList() {
        return commentList;
    }

    public interface PageContentCallback{

        int CODE_OK = 200;

        void onImgUriLoaded(int code);
        void onPageDataLoaded(int code);
        void onCommentsLoaded(int code);

    }
}
