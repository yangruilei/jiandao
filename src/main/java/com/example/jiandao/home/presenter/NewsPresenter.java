package com.example.jiandao.home.presenter;


import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.home.bean.NewsBean;
import com.example.jiandao.home.contract.NewsFragmentContract;
import com.example.jiandao.home.contract.RecommendContract;
import com.example.jiandao.home.model.NewsModel;
import com.example.jiandao.net.INetCallBack;

public class NewsPresenter extends BasePresenter<NewsFragmentContract.INewsView> implements RecommendContract.IRecommendPresenter {
    private NewsFragmentContract.INewsMode iNewsMode;

    @Override
    public void getColumList() {

    }

    public NewsPresenter() {

        iNewsMode = new NewsModel();

    }

    @Override
    public void getRecommendList(String id) {
        iNewsMode.getRecommendList(id,new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {

                mview.setRecommendList(newsBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


    }
}
