package com.nulldreams.beblog;

import com.nulldreams.beblog.module.Blogs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by gaoyunfei on 2017/1/31.
 */

public interface BlogService {

    public static final String BASE_URL = "https://www.googleapis.com/blogger/v3/";

    @GET("blogs/{blogId}")
    Call<Blogs> getBlogs (@Path("blogId") String blogId, @Query("key") String key);

    @GET("users/{userId}")
    Call<Blogs> getUsers (@Path("userId") String userId, @Query("access_token") String key);
}
