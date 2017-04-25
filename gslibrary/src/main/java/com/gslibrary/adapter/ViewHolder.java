package com.gslibrary.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

public class ViewHolder {
	private final SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	// TODO 完善options的配置
	private ImageOptions opSquaer = new ImageOptions.Builder()
			// 设置加载过程中的图片
			.setUseMemCache(true).setImageScaleType(ScaleType.FIT_XY)
			// 设置显示圆形图片
			.setFadeIn(true).build();
	private ImageOptions opRound = new ImageOptions.Builder()
			// 设置加载过程中的图片
			.setUseMemCache(true).setImageScaleType(ScaleType.CENTER_CROP)
			// 设置显示圆形图片
			.setCircular(true).setFadeIn(true).build();

	private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		// setTag
		mConvertView.setTag(this);
	}

	/**
	 * 拿到一个ViewHolder对象
	 *
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId, position);
		}
		return (ViewHolder) convertView.getTag();
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 *
	 * @param viewId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 为TextView设置字符串
	 *
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder setText(int viewId, String text) {
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}

	public ViewHolder setText(int viewId, int resId) {
		TextView view = getView(viewId);
		view.setText(resId);
		return this;
	}

	/**
	 * 设置原形头像图片
	 *
	 * @param viewId
	 * @param url
	 * @return
	 */
	public ViewHolder setRoundAvatarByUrl(int viewId, String url) {
		ImageView view = this.getView(viewId);
		x.image().bind(view, url, opRound);
		return this;
	}

	public ViewHolder setSquareImageByUrl(int viewId, String url) {
		ImageView view = this.getView(viewId);
		x.image().bind(view, url, opSquaer);
		return this;
	}

	public ViewHolder setImageByUrl(int viewId, String url) {
		ImageView view = this.getView(viewId);
		x.image().bind(view, url);
		return this;
	}

	public ViewHolder setImageByLocal(int localImgId, int imgId) {
		ImageView iv = this.getView(imgId);
		iv.setImageResource(localImgId);
		return this;
	}

	public int getPosition() {
		return mPosition;
	}

}