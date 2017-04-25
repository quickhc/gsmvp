package com.gslibrary.utils;

import android.widget.ImageView;

import com.gslibrary.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

public class ImageUtils {

    public static final ImageOptions defaultImage=new ImageOptions.Builder()
            .setImageScaleType(ImageView.ScaleType.FIT_CENTER)
            .setFailureDrawableId(R.drawable.picgoodsb).build();


    public void setImageForUrl(){
        //TODO
        x.image().bind(new ImageView(x.app().getApplicationContext()),"",defaultImage);
    }

}
