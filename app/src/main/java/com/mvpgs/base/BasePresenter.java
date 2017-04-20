package com.mvpgs.base;

public interface BasePresenter<T> {
	void attachView(T view);

	void detachView();
}