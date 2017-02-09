package com.nulldreams.beone.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nulldreams.adapter.AbsViewHolder;
import com.nulldreams.adapter.DelegateAdapter;
import com.nulldreams.base.content.It;
import com.nulldreams.beone.Finals;
import com.nulldreams.beone.R;
import com.nulldreams.beone.activity.MovieDetailActivity;
import com.nulldreams.beone.manager.GlideManager;
import com.nulldreams.beone.module.Content;

/**
 * Created by gaoyunfei on 2017/2/2.
 */

public class MovieHolder extends AbsViewHolder<MovieDelegate> {

    private ImageView thumbIv;
    private TextView titleTv;

    public MovieHolder(View itemView) {
        super(itemView);
        thumbIv = (ImageView)findViewById(R.id.movie_thumb);
        titleTv = (TextView)findViewById(R.id.movie_title);
    }

    @Override
    public void onBindView(final Context context, MovieDelegate movieDelegate, int position, DelegateAdapter adapter) {
        final Content content = movieDelegate.getSource();
        GlideManager.getInstance(context).displayThumb(content.img_url, thumbIv);
        titleTv.setText(content.video_url);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                It.newInstance().putExtra(Finals.KEY_CONTENT, content).startActivity(context, MovieDetailActivity.class);
            }
        });
    }
}
