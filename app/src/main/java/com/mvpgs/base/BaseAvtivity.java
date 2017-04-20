package com.mvpgs.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseAvtivity<V, T extends BasePresenter<V>> extends FragmentActivity {

	private T t;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setConView();
		t = initPresenter();
		t.attachView((V) this);
	}

	protected abstract void setConView();

	protected abstract T initPresenter();

	@Override
	protected void onDestroy() {
		super.onDestroy();
		t.detachView();
	}
}
