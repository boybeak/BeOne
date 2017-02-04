package com.nulldreams.beone.manager;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.nulldreams.base.manager.AbsManager;
import com.nulldreams.beone.module.Content;
import com.nulldreams.beone.module.MovieDetail;
import com.nulldreams.beone.module.MusicDetail;
import com.nulldreams.beone.module.OneList;
import com.nulldreams.beone.module.TextDetail;
import com.nulldreams.beone.retrofit.OneService;
import com.nulldreams.beone.retrofit.Result;

import java.util.List;
import java.util.UUID;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gaoyunfei on 2017/1/31.
 */

public class OneManager extends AbsManager {

    private static OneManager sManager;

    public static synchronized OneManager getInstance (Context context) {
        if (sManager == null) {
            sManager = new OneManager(context.getApplicationContext());
        }
        return sManager;
    }

    private String androidId = null;

    private OneService mService;

    private OneManager(Context context) {
        super(context);

        /*androidId = Settings.Secure.getString(getContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);*/
        androidId = UUID.randomUUID().toString();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.addInterceptor(logging);

        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd HH:mm");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://v3.wufazhuce.com:8000/api/")
                .client(okBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .build();
        mService = retrofit.create(OneService.class);
    }

    public void getIdList (Callback<Result<int[]>> callback) {
        Call<Result<int[]>> resultCall = mService.getIdList(androidId);
        resultCall.enqueue(callback);
    }

    public void getOneList (int id, Callback<Result<OneList>> callback) {
        Call<Result<OneList>> resultCall = mService.getOneList(id, androidId);
        resultCall.enqueue(callback);
    }

    public void getReadingList (int last_id, Callback<Result<List<Content>>> callback) {
        Call<Result<List<Content>>> resultCall = mService.getReadingList(last_id, androidId);
        resultCall.enqueue(callback);
    }

    public void getMusicList (int last_id, Callback<Result<List<Content>>> callback) {
        Call<Result<List<Content>>> resultCall = mService.getMusicList(last_id, androidId);
        resultCall.enqueue(callback);
    }
    public void getMovieList (int last_id, Callback<Result<List<Content>>> callback) {
        Call<Result<List<Content>>> resultCall = mService.getMovieList(last_id, androidId);
        resultCall.enqueue(callback);
    }
    public void getTextDetail (int item_id, Callback<Result<TextDetail>> callback) {
        mService.getTextDetail(item_id, androidId).enqueue(callback);
    }

    public void getMusicDetail (int item_id, Callback<Result<MusicDetail>> callback) {
        mService.getMusicDetail(item_id, androidId).enqueue(callback);
    }

    public void getMovieDetail (int item_id, Callback<Result<MovieDetail>> callback) {
        mService.getMovieDetail(item_id, androidId).enqueue(callback);
    }
}
