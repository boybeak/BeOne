package com.nulldreams.beone.adapter;

import com.nulldreams.adapter.annotation.AnnotationDelegate;
import com.nulldreams.adapter.annotation.DelegateInfo;
import com.nulldreams.beone.R;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/2/2.
 */
@DelegateInfo(layoutID = R.layout.layout_image, holderClass = ImageHolder.class)
public class ImageDelegate extends AnnotationDelegate<Content>{
    public ImageDelegate(Content content) {
        super(content);
    }
}
