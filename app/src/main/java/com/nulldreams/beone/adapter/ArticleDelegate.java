package com.nulldreams.beone.adapter;

import com.nulldreams.adapter.annotation.AnnotationDelegate;
import com.nulldreams.adapter.annotation.DelegateInfo;
import com.nulldreams.beone.R;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/2/2.
 */
@DelegateInfo(layoutID = R.layout.layout_article, holderClass = ArticleHolder.class)
public class ArticleDelegate extends AnnotationDelegate<Content> {
    public ArticleDelegate(Content content) {
        super(content);
    }
}
