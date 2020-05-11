package com.example.jiandao.login.presenter;

import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.login.bean.AffirmRegisterBean;
import com.example.jiandao.login.contract.AffirmContract;
import com.example.jiandao.login.model.AffirmRegisterModel;
import com.example.jiandao.net.INetCallBack;


public class AffirmRegisterPresenter extends BasePresenter<AffirmContract.IAffirmView> implements AffirmContract.IAffirmPresenter {

    private AffirmContract.IAffirmMode iAffirmMode;
    public AffirmRegisterPresenter() {

        iAffirmMode = new AffirmRegisterModel();

    }

    @Override
    public void register(String phoneNum, String password, String affirm_password) {
        iAffirmMode.register(phoneNum, password, affirm_password, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean registerBean) {
                mview.registerResult(registerBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
