package com.nulldreams.beone.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nulldreams.beone.Finals;
import com.nulldreams.beone.R;
import com.nulldreams.beone.manager.OneManager;
import com.nulldreams.beone.module.Content;
import com.nulldreams.beone.module.TextDetail;
import com.nulldreams.beone.retrofit.Result;
import com.tencent.smtt.sdk.WebView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TextDetailActivity extends AppCompatActivity {

    private static final String TAG = TextDetailActivity.class.getSimpleName();

    private Content mContent;

    private WebView mWv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_detail);

        mWv = (WebView)findViewById(R.id.text_wv);

        mContent = (Content)getIntent().getSerializableExtra(Finals.KEY_CONTENT);

        OneManager.getInstance(this).getTextDetail(mContent.item_id, new Callback<Result<TextDetail>>() {
            @Override
            public void onResponse(Call<Result<TextDetail>> call, Response<Result<TextDetail>> response) {
                Log.v(TAG, "onResponse");
                mWv.loadUrl(response.body().data.web_url);
            }

            @Override
            public void onFailure(Call<Result<TextDetail>> call, Throwable t) {
                Log.v(TAG, "onFailure " + t.getLocalizedMessage());
            }
        });
    }
}
