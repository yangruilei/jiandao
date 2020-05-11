package com.example.jiandao.login.contract;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.bean.AffirmRegisterBean;
import com.example.jiandao.net.INetCallBack;

/**
 * 注册获取短信验证码
 */
public class AffirmContract {

        public interface IAffirmView extends BaseView {

//            逻辑判断在P层判断--为了简单一点，扔道Acitivty
            void registerResult(AffirmRegisterBean registerBean);
        }
        public interface IAffirmMode{
            <T> void register(String phoneNum, String password, String affirm_password, INetCallBack<T> iNetCallBack);
        }
        public interface IAffirmPresenter{
            void register(String phoneNum, String password, String affirm_password);

        }
}
