package com.mvpgs.presenter;

import com.gslibrary.base.BasePresenter;
import com.gslibrary.http.XCallBack;
import com.gslibrary.http.XutilsHttp;
import com.mvpgs.utils.RMPparams;
import com.mvpgs.utils.UrlConston;
import com.mvpgs.view.LoginView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*********************************************
 ***       河南坚磐科技电子有限公司        ***
 ***                                       ***
 ***       Created by HC on 2017/4/24.       ***
 *********************************************/

public class LoginPresenter extends BasePresenter<LoginView> {

    public void onBtnClick(String username, String password) {
        sendHttp(UrlConston.aus, new RMPparams().getAus());
    }

    ;

    @Override
    public void sendHttp(String url, Map<String, String> params) {
        XutilsHttp.getInstance().upLoadJson(url, params, new XCallBack() {
            @Override
            public boolean onResponse(String result) {
                boolean is = super.onResponse(result);
                if (is) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        if ("200".equals(jsonObject.getString("resultcode"))) {
                            List<String> mlist = new ArrayList<String>();
                            for (int i = 0; i < 10; i++) {
                                mlist.add("" + i);
                            }
                            mView.loginSuccess(mlist);
                        } else {
                            mView.loginFail(jsonObject.getString("reason"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                return true;
            }

            @Override
            public void onFail(String result) {
                mView.loginFail(result);
            }


        });
    }
}
