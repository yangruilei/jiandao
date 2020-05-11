package com.example.jiandao.login.presenter;


import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.login.bean.VerfiedBean;
import com.example.jiandao.login.contract.RegisterMSMContract;
import com.example.jiandao.login.model.RegisterMSMModel;
import com.example.jiandao.net.INetCallBack;

public class RegisterMSMPresenter extends BasePresenter<RegisterMSMContract.IRegisterMSMView> implements RegisterMSMContract.IRegisterMSMPresenter {

    private RegisterMSMContract.IRegisterMSMMode iRegisterMSMMode;

    public RegisterMSMPresenter() {
        iRegisterMSMMode = new RegisterMSMModel();
    }

    @Override
    public void getVerified(String string, String type) {

        iRegisterMSMMode.getVerified(string, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mview.getVerified(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {

        iRegisterMSMMode.checkSmsCode(phoneNum, smsCode, type, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {

                mview.checkSmsCodeResult(verfiedBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });



    }
}
