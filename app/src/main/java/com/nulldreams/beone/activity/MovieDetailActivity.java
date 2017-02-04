package com.nulldreams.beone.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.nulldreams.beone.Finals;
import com.nulldreams.beone.R;
import com.nulldreams.beone.manager.OneManager;
import com.nulldreams.beone.module.Content;
import com.nulldreams.beone.module.MovieDetail;
import com.nulldreams.beone.retrofit.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailActivity extends AppCompatActivity {

    private TextView mContentTv;

    private Content mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mContent = (Content)getIntent().getSerializableExtra(Finals.KEY_CONTENT);

        mContentTv = (TextView)findViewById(R.id.movie_detail_content);

        OneManager.getInstance(this).getMovieDetail(mContent.item_id, new Callback<Result<MovieDetail>>() {
            @Override
            public void onResponse(Call<Result<MovieDetail>> call, Response<Result<MovieDetail>> response) {
                mContentTv.setText(Html.fromHtml(response.body().data.data[0].content));
            }

            @Override
            public void onFailure(Call<Result<MovieDetail>> call, Throwable t) {

            }
        });
    }

    private class Getter implements Html.ImageGetter {

        @Override
        public Drawable getDrawable(String source) {
            return null;
        }
    }
}
