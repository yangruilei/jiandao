package com.example.jiandao.login.presenter;


import com.example.jiandao.base.BasePresenter;
import com.example.jiandao.login.bean.VerfiedBean;
import com.example.jiandao.login.contract.AffirmPassWordContract;
import com.example.jiandao.login.model.AffirmPaswMode;
import com.example.jiandao.net.INetCallBack;

public class AffirmPaswPresenter extends BasePresenter<AffirmPassWordContract.IAffirmPaswView> implements AffirmPassWordContract.IAffirmPaswPresenter {

    private AffirmPassWordContract.IAffirmPaswMode iAffirmPaswMode;

    public AffirmPaswPresenter() {

        iAffirmPaswMode = new AffirmPaswMode();

    }

    @Override
    public void forgetPasw(String phoneNum, String sms, String password) {

        iAffirmPaswMode.forgetPasw(phoneNum, sms, password, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean bean) {

                mview.registerResult(bean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }
}
