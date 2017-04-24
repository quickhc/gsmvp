package com.gslibrary.app;

import android.app.Application;

import org.xutils.x;

/*********************************************
 * 初始化App
 ***       Created by HC on 2017/4/24.       ***
 *********************************************/

public class SAppLication extends Application {
    private Application mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        /**
         * xutils初始化
         */
        x.Ext.init(this);
    }

    /**
     * 获取context对象
     *
     * @return
     */
    public Application getmContext() {
        return mContext;
    }

    /**
     * 是否启用debug模式
     *
     * @param isDebug
     */
    public void setXutilsDebug(boolean isDebug) {
        x.Ext.setDebug(isDebug);
    }
}
