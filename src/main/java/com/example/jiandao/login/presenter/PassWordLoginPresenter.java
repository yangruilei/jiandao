package com.example.jiandao.login.presenter;


import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.login.bean.AffirmRegisterBean;
import com.example.jiandao.login.contract.PassWordLoginContract;
import com.example.jiandao.login.model.PassWordLoginModel;
import com.example.jiandao.net.INetCallBack;

public class PassWordLoginPresenter extends BasePresenter<PassWordLoginContract.IPassWordLoginView> implements PassWordLoginContract.IPassWordLoginPresenter {

    private PassWordLoginContract.IPassWordLoginMode iPassWordLoginMode;

    public PassWordLoginPresenter() {
        iPassWordLoginMode = new PassWordLoginModel();
    }

    @Override
    public void passWordLogin(String username, String password) {

        iPassWordLoginMode.passWordLogin(username, password, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean affirmRegisterBean) {

                mview.getPWLoginResult(affirmRegisterBean);

            }
            @Override
            public void onError(Throwable throwable) {

//                这里去通知V层刷新失败得结果


            }
        });

    }
}
