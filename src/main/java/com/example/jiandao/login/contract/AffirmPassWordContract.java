package com.example.jiandao.login.contract;


import com.example.jiandao.base.BaseView;
import com.example.jiandao.login.bean.VerfiedBean;
import com.example.jiandao.net.INetCallBack;

public class AffirmPassWordContract {


    public interface IAffirmPaswView extends BaseView {

        //            逻辑判断在P层判断--为了简单一点，扔道Acitivty
        void registerResult(VerfiedBean bean);
    }
    public interface IAffirmPaswMode{
        <T> void forgetPasw(String mobile, String sms_code, String password, INetCallBack<T> iNetCallBack);
    }
    public interface IAffirmPaswPresenter{
        void forgetPasw(String mobile, String sms_code, String password);

    }
}
