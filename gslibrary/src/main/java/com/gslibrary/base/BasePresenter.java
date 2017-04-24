package com.gslibrary.base;


import java.util.Map;

/**
 * basePresenter类
 * @param <T>
 */
public abstract class BasePresenter<T> {
    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }

    public abstract void sendHttp(String url, Map<String, String> params);

}
