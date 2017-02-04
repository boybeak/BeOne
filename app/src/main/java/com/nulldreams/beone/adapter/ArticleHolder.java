package com.nulldreams.beone.adapter;

import android.content.Context;
import android.view.View;

import com.nulldreams.adapter.AbsViewHolder;
import com.nulldreams.adapter.DelegateAdapter;

/**
 * Created by gaoyunfei on 2017/2/2.
 */

public class ArticleHolder extends AbsViewHolder<ArticleDelegate> {
    public ArticleHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindView(Context context, ArticleDelegate articleDelegate, int position, DelegateAdapter adapter) {

    }
}
