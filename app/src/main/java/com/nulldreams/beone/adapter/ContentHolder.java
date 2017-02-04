package com.nulldreams.beone.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nulldreams.adapter.AbsViewHolder;
import com.nulldreams.adapter.DelegateAdapter;
import com.nulldreams.beone.Finals;
import com.nulldreams.beone.R;
import com.nulldreams.beone.activity.TextDetailActivity;
import com.nulldreams.beone.manager.GlideManager;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/1/31.
 */

public class ContentHolder extends AbsViewHolder<ContentDelegate> {

    private static final String TAG = ContentHolder.class.getSimpleName();

    private TextView titleTv, descTv;
    private ImageView thumbIv;

    public ContentHolder(View itemView) {
        super(itemView);
        titleTv = (TextView)findViewById(R.id.content_title);
        descTv = (TextView)findViewById(R.id.content_desc);
        thumbIv = (ImageView)findViewById(R.id.content_thumb);
    }

    @Override
    public void onBindView(final Context context, ContentDelegate contentDelegate, int position, DelegateAdapter adapter) {
        final Content content = contentDelegate.getSource();
        titleTv.setText(content.title);
        descTv.setText(content.forward);
        GlideManager.getInstance(context).displayThumb(content.img_url, thumbIv);
        Log.v(TAG, "onBindView " + content.img_url + " " + content.audio_url + " " + content.video_url);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(
                        new Intent(context, TextDetailActivity.class)
                                .putExtra(Finals.KEY_CONTENT, content));
            }
        });
    }
}
