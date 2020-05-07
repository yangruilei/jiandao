package com.example.jiandao;

import android.util.Log;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.net.INetCallBack;


public class MainPresenter  extends BasePresenter<MainActivity> implements MainContract.IMainPresenter {

    private MainContract.IMainMode iMainMode;

    public MainPresenter() {
        iMainMode = new MainModel();
    }

    @Override
    public void getRecommendList() {

        iMainMode.getRecommendList(new INetCallBack<RemBean>() {
            @Override
            public void onSuccess(RemBean remBean) {


                Log.e("TAG","打印网络请求返回实体类:"+remBean.toString());

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }
}
