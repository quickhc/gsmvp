package com.mvpgs.activity;

import android.view.View;
import android.widget.Button;

import com.gslibrary.base.BaseMvpActivity;
import com.mvpgs.R;
import com.mvpgs.presenter.LoginPresenter;
import com.mvpgs.view.LoginView;

/*********************************************
 ***       河南坚磐科技电子有限公司        ***
 ***                                       ***
 ***       Created by HC on 2017/4/24.       ***
 *********************************************/

public class LoginActivity extends BaseMvpActivity<LoginView,LoginPresenter> implements LoginView {

    private LoginPresenter loginPresenter;

    private Button bt;

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void setContentView() {
        setContentView(R.layout.main_activity);
        loginPresenter=new LoginPresenter();
    }

    @Override
    public void initView() {
        bt= (Button) findViewById(R.id.bt);
    }

    @Override
    public void initListen() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onBtnClick("郑州","8e02612c49de6528d80a429fc865faa");
            }
        });
    }
    @Override
    public LoginPresenter initPresenter() {
        return loginPresenter;
    }

    @Override
    public void loginSuccess() {
        toastShow("登录成功");
    }

    @Override
    public void loginFail(String message) {
        toastShow(message);
    }
}
