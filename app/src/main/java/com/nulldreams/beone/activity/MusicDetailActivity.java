package com.nulldreams.beone.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.nulldreams.beone.Finals;
import com.nulldreams.beone.R;
import com.nulldreams.beone.manager.OneManager;
import com.nulldreams.beone.module.Content;
import com.nulldreams.beone.module.MusicDetail;
import com.nulldreams.beone.retrofit.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicDetailActivity extends AppCompatActivity {

    private Content mContent;

    private TextView mContentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);

        mContentTv = (TextView)findViewById(R.id.music_detail_content);

        mContent = (Content)getIntent().getSerializableExtra(Finals.KEY_CONTENT);

        OneManager.getInstance(this).getMusicDetail(mContent.item_id, new Callback<Result<MusicDetail>>() {
            @Override
            public void onResponse(Call<Result<MusicDetail>> call, Response<Result<MusicDetail>> response) {
                mContentTv.setText(Html.fromHtml(response.body().data.story));
            }

            @Override
            public void onFailure(Call<Result<MusicDetail>> call, Throwable t) {

            }
        });
    }
}
