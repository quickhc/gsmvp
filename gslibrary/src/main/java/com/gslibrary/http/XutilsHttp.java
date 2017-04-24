package com.gslibrary.http;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;


/*********************************************
 * 通用网络请求
 ***       Created by HC on 2017/4/14.       ***
 *********************************************/

public class XutilsHttp {
    private volatile static XutilsHttp instance;
    private Handler handler;

    private XutilsHttp() {
        handler = new Handler(Looper.getMainLooper());
    }

    /**
     *   * 单利模式
     *   * @return
     *   
     */
    public static XutilsHttp getInstance() {
        if (instance == null) {
            synchronized (XutilsHttp.class) {
                if (instance == null) {
                    instance = new XutilsHttp();
                }
            }
        }
        return instance;
    }

    /**
     * 普通get请求
     *
     * @param url
     * @param maps
     * @param callback
     */
    public void get(String url, Map<String, String> maps, final XCallBack callback) {
        RequestParams params = new RequestParams(url);
        if (null != maps && !maps.isEmpty()) {
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        x.http().get(params, new Callback.CommonCallback<String>() {
            private boolean hasError = false;
            private String result = null;

            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    this.result = result;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                hasError = true;
                Toast.makeText(x.app().getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                if (!hasError && result != null) {
                    callback.onResponse(result);
                }
            }
        });
    }
}

