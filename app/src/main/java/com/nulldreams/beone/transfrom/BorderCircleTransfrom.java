package com.nulldreams.beone.transfrom;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by gaoyunfei on 2017/2/2.
 */

public class BorderCircleTransfrom extends CropCircleTransformation {

    public BorderCircleTransfrom(Context context) {
        super(context);
    }

    public BorderCircleTransfrom(BitmapPool pool) {
        super(pool);
    }

    @Override
    public Resource<Bitmap> transform(Resource<Bitmap> resource, int outWidth, int outHeight) {
        return super.transform(resource, outWidth, outHeight);
    }

    @Override
    public String getId() {
        return "BorderCircleTransfrom()";
    }
}
