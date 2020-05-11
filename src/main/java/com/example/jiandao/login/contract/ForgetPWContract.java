package com.example.jiandao.login.contract;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.bean.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class ForgetPWContract {

        public interface IForgetPWView extends BaseView {

//            逻辑判断在P层判断--为了简单一点，扔道Acitivty
            void getVerified(VerfiedBean s);

            void checkSmsCodeResult(VerfiedBean verfiedBean);

        }
        public interface IForgetPWMode{
           <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);

            <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack);
        }
        public interface IForgetPWPresenter{
            void getVerified(String string, String type);
            void checkSmsCode(String phoneNum, String smsCode, String type);
        }
}
