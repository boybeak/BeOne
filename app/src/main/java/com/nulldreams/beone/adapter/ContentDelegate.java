package com.nulldreams.beone.adapter;

import com.nulldreams.adapter.annotation.AnnotationDelegate;
import com.nulldreams.adapter.annotation.DelegateInfo;
import com.nulldreams.beone.R;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/1/31.
 */
@DelegateInfo(layoutID = R.layout.layout_content, holderClass = ContentHolder.class)
public class ContentDelegate extends AnnotationDelegate<Content> {

    public ContentDelegate(Content content) {
        super(content);
    }
}
