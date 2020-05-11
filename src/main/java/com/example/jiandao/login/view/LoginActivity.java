package com.example.jiandao.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseActivity;
import com.example.jiandao.login.bean.AffirmRegisterBean;
import com.example.jiandao.login.bean.VerfiedBean;
import com.example.jiandao.login.contract.LoginContract;
import com.example.jiandao.login.presenter.LoginPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {


    private EditText phone_num;
    private EditText verfied;
    private TextView send_verfied_bug;
    private Button login;

    private TextView pass_login;
    private TextView login_to_reg;


    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void initView() {
          phone_num = findViewById(R.id.cell_phone_number);
          verfied= findViewById(R.id.import_verification);
          send_verfied_bug= findViewById(R.id.verification);
          login= findViewById(R.id.verification_login);
        pass_login = findViewById(R.id.pass_login);
        login_to_reg =  findViewById(R.id.login_to_reg);

    }

    @Override
    public void initData() {

    }

  private   String edit_phone_num;
   private String edit_sms_code;

    @Override
    public void initLinstener() {

        pass_login.setOnClickListener(v -> {

        });
        login_to_reg.setOnClickListener(v -> {
            Intent intent = new Intent(this,RegisterMSMCodeActivity.class);
            startActivity(intent);
        });


// 发送验证码
        send_verfied_bug.setOnClickListener(v->{
//判断咱们手机号是否为空，判断手机号是否正确，发送咱们验证码
            String phonenum = phone_num.getText().toString();
            if( !TextUtils.isEmpty(phonenum) && isMobileNO(phonenum)){
// 表示可以发送验证码  type 4表示登录发送验证码
                mPresenter.getVerified(phonenum,"4");
            }else Toast.makeText(LoginActivity.this, "请输入正确得手机号", Toast.LENGTH_SHORT).show();
        });

//登录
        login.setOnClickListener(v->{
            edit_phone_num = phone_num.getText().toString();
            edit_sms_code = verfied.getText().toString();
            if( !TextUtils.isEmpty(edit_phone_num) && isMobileNO(edit_phone_num)){
                if( !TextUtils.isEmpty(edit_sms_code)){
// 需要用正则表达式判断验证码是否是6位，且都是数字
                    Pattern pattern = Pattern.compile("\\d{6}");
                    boolean matches = pattern.matcher(edit_sms_code).matches();
                    if(matches){
 // 判断你得手机号，和你发送得验证码是否正确，如果正确，调用登录接口
// 提交服务器进行判读
                        Log.e("TAG",edit_phone_num+"验证码值："+edit_sms_code);

                        mPresenter.checkSmsCode(edit_phone_num,edit_sms_code,"4");


// 如果不正确，提示用户
                    }else Toast.makeText(LoginActivity.this, "验证码输入错误", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(LoginActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
            }else Toast.makeText(LoginActivity.this, "请输入正确得手机号", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }




// 发送验证码返回
    @Override
    public void getVerified(VerfiedBean s) {
        if(s.getCode() ==1){
            Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void getLoginResult(AffirmRegisterBean registerBean) {



        if(registerBean.getCode()==1) {

            Toast.makeText(this, "登录成功返回数据，且code等于1", Toast.LENGTH_SHORT).show();

            if (null != registerBean.getData().getToken().getValue() && registerBean.getData().getToken().getValue() != "") {

                MMKV mmkv = MMKV.defaultMMKV();



                mmkv.encode("token", registerBean.getData().getToken().getValue());
                mmkv.encode("expire_time", registerBean.getData().getToken().getExpire_time());
                mmkv.encode("head_url", registerBean.getData().getUser_info().getHead_url());
                mmkv.encode("nickname", registerBean.getData().getUser_info().getNickname());
                mmkv.encode("mobile", registerBean.getData().getUser_info().getMobile());

                Toast.makeText(this, "登录成功，跳转HomeActivity", Toast.LENGTH_SHORT).show();
                
            }
        }

    }

//验证码是否正确返回
    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {

        if(verfiedBean.getCode() ==1){

            mPresenter.login(edit_phone_num,edit_sms_code);

        }else Toast.makeText(this, "验证码输入错误", Toast.LENGTH_SHORT).show();


    }


    public static boolean isMobileNO(String mobiles){
        boolean flag = false;
        try{
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        }catch(Exception e){

            Log.e("TAG","手机号错误"+e.getMessage());
            flag = false;
        }
        return flag;
    }


}
