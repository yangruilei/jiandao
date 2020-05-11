package com.example.jiandao.login.contract;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.bean.AffirmRegisterBean;
import com.example.jiandao.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class PassWordLoginContract {

        public interface IPassWordLoginView extends BaseView {
            void  getPWLoginResult(AffirmRegisterBean string);
        }
        public interface IPassWordLoginMode{
            <T> void passWordLogin(String username, String password, INetCallBack<T> iNetCallBack);
        }
        public interface IPassWordLoginPresenter{
            void passWordLogin(String username, String password);
        }
}
