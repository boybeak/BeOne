package com.nulldreams.beone.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nulldreams.adapter.AbsViewHolder;
import com.nulldreams.adapter.DelegateAdapter;
import com.nulldreams.beone.Finals;
import com.nulldreams.beone.R;
import com.nulldreams.beone.activity.MusicDetailActivity;
import com.nulldreams.beone.module.Content;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by gaoyunfei on 2017/2/2.
 */

public class MusicHolder extends AbsViewHolder<MusicDelegate> {

    private ImageView thumbIv, thumbRoundIv;
    private TextView titleTv, descTv;

    public MusicHolder(View itemView) {
        super(itemView);

        thumbIv = (ImageView)findViewById(R.id.music_thumb);
        thumbRoundIv = (ImageView)findViewById(R.id.music_thumb_round);
        titleTv = (TextView)findViewById(R.id.music_title);
        descTv = (TextView)findViewById(R.id.music_desc);
    }

    @Override
    public void onBindView(final Context context, MusicDelegate musicDelegate, int position, DelegateAdapter adapter) {
        final Content content = musicDelegate.getSource();
        Glide.with(context).load(content.img_url).asBitmap().transform(new BlurTransformation(context)).into(thumbIv);
        if (content.hasMusic()) {
            Glide.with(context).load(content.img_url).asBitmap().transform(new CropCircleTransformation(context)).into(thumbRoundIv);
            thumbRoundIv.setVisibility(View.VISIBLE);
        } else {
            thumbRoundIv.setImageDrawable(null);
            thumbRoundIv.setVisibility(View.GONE);
        }
        titleTv.setText(content.title);
        descTv.setText(content.forward);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(
                        new Intent(context, MusicDetailActivity.class)
                        .putExtra(Finals.KEY_CONTENT, content));
            }
        });
    }
}
