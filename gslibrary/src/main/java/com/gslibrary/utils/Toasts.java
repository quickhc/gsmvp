package com.gslibrary.utils;

import android.widget.Toast;

import org.xutils.x;

/**
 * Toast弹窗工具类
 */
public class Toasts {
    private Toasts() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * ��ʱ����ʾToast
     *
     * @param context
     * @param message
     */
    public static void showShort(CharSequence message) {
        if (isShow)
            Toast.makeText(x.app().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(int strRes) {
        if (isShow) {
            Toast.makeText(x.app().getApplicationContext(), strRes, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * ��ʱ����ʾToast
     *
     * @param context
     * @param message
     */
    public static void showLong(CharSequence message) {
        if (isShow)
            Toast.makeText(x.app().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public static void showLong(int strRes) {
        if (isShow)
            Toast.makeText(x.app().getApplicationContext(), strRes, Toast.LENGTH_LONG).show();
    }

}
