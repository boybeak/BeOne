package com.nulldreams.beone.adapter;

import com.nulldreams.adapter.annotation.AnnotationDelegate;
import com.nulldreams.adapter.annotation.DelegateInfo;
import com.nulldreams.beone.R;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/2/2.
 */
@DelegateInfo(layoutID = R.layout.layout_essay, holderClass = EssayHolder.class)
public class EssayDelegate extends AnnotationDelegate<Content> {
    public EssayDelegate(Content content) {
        super(content);
    }
}
