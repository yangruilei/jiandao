package com.example.jiandao.home.contract;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class HomeContract {

        public interface IHomeView extends BaseView {
            void  setBannView(String string);
//            定义V层操作接口集合    更新页面操作，接口定义好
//            toast    set数据setText，get页面数据getText
//            获取数据

            void setTabList(String string);

        }
        public interface IHomeMode{
           <T> void getHomeBannview(INetCallBack<T> iNetCallBack);
//            一个网络请求，登录    ，   首页，4-N接口    getData
//            网络请求，数据库   sp    文件File
            <T> void getHomeTabList(INetCallBack<T> iNetCallBack);
        }
        public interface IHomePresenter{
            void callHomeBannview(String string);
            void getBannerView();
            void getHomeTabList();
//            它两交互时候，需要什么操作
        }
}
