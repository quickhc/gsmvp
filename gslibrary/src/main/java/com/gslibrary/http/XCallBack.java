package com.gslibrary.http;

import com.gslibrary.utils.LogUtils;

/**
 * 通用回调类
 */
public class XCallBack {

    public final static String Tag = "CallBack";

    public void onResponse(String result) {
        LogUtils.i(Tag, result);
    }

    ;

    public void onFail(String result) {
    }

    ;
}