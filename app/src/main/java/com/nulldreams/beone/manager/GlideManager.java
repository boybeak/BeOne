package com.nulldreams.beone.manager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nulldreams.base.manager.AbsManager;

/**
 * Created by gaoyunfei on 2017/2/1.
 */

public class GlideManager extends AbsManager {

    private static GlideManager sManager;
    public static synchronized GlideManager getInstance (Context context) {
        if (sManager == null) {
            sManager = new GlideManager(context.getApplicationContext());
        }
        return sManager;
    }

    private GlideManager(Context context) {
        super(context);
    }

    public void displayThumb (String url, ImageView iv) {
        Glide.with(getContext()).load(url).into(iv);
    }
}
