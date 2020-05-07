package com.example.jiandao;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class MainContract {

        public interface IMainView extends BaseView {

        }

        public interface IMainMode{
          <T>  void getRecommendList(INetCallBack<T> netCallBack);
        }

        public interface IMainPresenter{

            void getRecommendList();

//            它两交互时候，需要什么操作
        }
}
