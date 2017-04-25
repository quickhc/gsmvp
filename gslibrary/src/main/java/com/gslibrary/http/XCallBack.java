package com.gslibrary.http;

import com.gslibrary.utils.LogUtils;

/**
 * 通用网络请求回调
 */
public class XCallBack {

    public final static String Tag = "CallBack";

    public void onResponse(String result) {
        LogUtils.i(Tag, result);
    }

    public void onFail(String result) {
    }

}