package com.gslibrary.app;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import org.xutils.x;

public class SAppLication extends Application {
    private Application mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        x.Ext.init(this);
        //二维码初始化
        ZXingLibrary.initDisplayOpinion(this);
    }

    public Application getmContext() {
        return mContext;
    }

    public void setXutilsDebug(boolean isDebug) {
        x.Ext.setDebug(isDebug);
    }
}
