package com.mvpgs.presenter;

import com.gslibrary.base.BasePresenter;
import com.gslibrary.http.XCallBack;
import com.gslibrary.http.XutilsHttp;
import com.mvpgs.utils.RMPparams;
import com.mvpgs.utils.UrlConston;
import com.mvpgs.view.LoginView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/*********************************************
 ***       河南坚磐科技电子有限公司        ***
 ***                                       ***
 ***       Created by HC on 2017/4/24.       ***
 *********************************************/

public class LoginPresenter extends BasePresenter<LoginView> {

    public void onBtnClick(String username,String password){
        sendHttp(UrlConston.url,new RMPparams().getLogin(username,password));
    };

    @Override
    public void sendHttp(String url,Map<String, String> params) {
        XutilsHttp.getInstance().get(url, params, new XCallBack() {
            @Override
            public void onResponse(String result) {
                super.onResponse(result);
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    if("200".equals(jsonObject.getString("resultcode"))){
                        mView.loginSuccess();
                    }else{
                        mView.loginFail(jsonObject.getString("reason"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFail(String result) {
                mView.loginFail("出错");
            }
        });
    }
}
