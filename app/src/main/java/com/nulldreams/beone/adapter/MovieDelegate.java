package com.nulldreams.beone.adapter;

import com.nulldreams.adapter.annotation.AnnotationDelegate;
import com.nulldreams.adapter.annotation.DelegateInfo;
import com.nulldreams.beone.R;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/2/2.
 */
@DelegateInfo(layoutID = R.layout.layout_movie, holderClass = MovieHolder.class)
public class MovieDelegate extends AnnotationDelegate<Content> {
    public MovieDelegate(Content content) {
        super(content);
    }
}
