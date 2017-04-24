package com.gslibrary.utils;

import android.widget.ImageView;

import com.gslibrary.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

/*********************************************
 ***        图片处理类                     ***
 ***       Created by HC on 2017/4/24.     ***
 *********************************************/

public class ImageUtils {

    public static final ImageOptions defaultImage=new ImageOptions.Builder()
            .setImageScaleType(ImageView.ScaleType.FIT_CENTER)//加载图片类型
            .setFailureDrawableId(R.drawable.picgoodsb).build();//失败的图片


    public void setImageForUrl(){
        x.image().bind(new ImageView(x.app().getApplicationContext()),"",defaultImage);
    }

}
