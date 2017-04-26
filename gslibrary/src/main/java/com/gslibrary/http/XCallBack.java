package com.gslibrary.http;

import com.gslibrary.utils.LogUtils;

/**
 * 通用网络请求回调
 */
public class XCallBack {

    public final static String Tag = "CallBack";

    //返回值用于全局判断
    public boolean onResponse(String result) {
        LogUtils.i(Tag, result);
//        if(!"".equals(result)){
//            onFail("123");
        return false;
//        }
    }

    public void onFail(String result) {
    }

}