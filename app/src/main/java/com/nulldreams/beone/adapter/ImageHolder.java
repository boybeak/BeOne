package com.nulldreams.beone.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nulldreams.adapter.AbsViewHolder;
import com.nulldreams.adapter.DelegateAdapter;
import com.nulldreams.beone.R;
import com.nulldreams.beone.manager.GlideManager;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/2/2.
 */

public class ImageHolder extends AbsViewHolder<ImageDelegate> {

    private ImageView thumbIv;
    private TextView descTv, wordsByTv, infoTv;

    public ImageHolder(View itemView) {
        super(itemView);
        thumbIv = (ImageView)findViewById(R.id.image_thumb);
        descTv = (TextView)findViewById(R.id.image_desc);
        wordsByTv = (TextView)findViewById(R.id.image_words_by);
        infoTv = (TextView)findViewById(R.id.image_info);
    }

    @Override
    public void onBindView(Context context, ImageDelegate imageDelegate, int position, DelegateAdapter adapter) {
        Content content = imageDelegate.getSource();
        GlideManager.getInstance(context).displayThumb(content.img_url, thumbIv);
        descTv.setText(content.forward);
        wordsByTv.setText("by " + content.words_info);
        infoTv.setText(content.title + " " + content.pic_info);
    }
}
