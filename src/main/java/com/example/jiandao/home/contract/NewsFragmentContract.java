package com.example.jiandao.home.contract;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.home.bean.NewsBean;
import com.example.jiandao.net.INetCallBack;

public class NewsFragmentContract {


    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean newsBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}
