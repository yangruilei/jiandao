package com.example.jiandao.home.contract;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.home.bean.ColunmBean;
import com.example.jiandao.home.bean.NewsBean;
import com.example.jiandao.net.INetCallBack;

public class RecommendContract {

    public interface IRecommendView extends BaseView {
//        给Activity返回推荐新闻列表
        void  setRecommendList(NewsBean string);
//        返回栏目列表
        void setColumList(ColunmBean columList);
    }
    public interface IRecommendMode{
//        获取推荐列表
        <T> void getRecommendList(String id, INetCallBack<T> iNetCallBack);
//        获取栏目列表
        <T> void getColumList(INetCallBack<T> iNetCallBack);
    }
    public interface IRecommendPresenter {
        void getColumList();
        void getRecommendList(String id);
    }


}
