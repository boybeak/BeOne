package com.nulldreams.beblog;

import android.content.Context;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.nulldreams.base.manager.AbsManager;
import com.nulldreams.beblog.module.Blogs;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gaoyunfei on 2017/2/12.
 */

public class BlogManager extends AbsManager {

    private static final String TAG = BlogManager.class.getSimpleName();

    private static BlogManager sManager = null;

    public static synchronized BlogManager getInstance (Context context) {
        if (sManager == null) {
            sManager = new BlogManager(context.getApplicationContext());
        }
        return sManager;
    }

    private BlogService mService;

    private BlogManager(Context context) {
        super(context);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.addInterceptor(logging);

        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd HH:mm");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BlogService.BASE_URL)
                .client(okBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .build();
        mService = retrofit.create(BlogService.class);
    }

    public void getBlogs (String token) {
        mService.getBlogs("969769369972-o06h78roirsf4s8lospohglrgun3j8d3.apps.googleusercontent.com", token)
                .enqueue(new Callback<Blogs>() {
            @Override
            public void onResponse(Call<Blogs> call, Response<Blogs> response) {

            }

            @Override
            public void onFailure(Call<Blogs> call, Throwable t) {

            }
        });
    }

    public void getUsers (String userId, String token) {
        mService.getUsers(userId, token).enqueue(new Callback<Blogs>() {
            @Override
            public void onResponse(Call<Blogs> call, Response<Blogs> response) {
                Log.v(TAG, "getUsers onResponse");
            }

            @Override
            public void onFailure(Call<Blogs> call, Throwable t) {
                Log.v(TAG, "getUsers onFailure");
            }
        });
    }
}
