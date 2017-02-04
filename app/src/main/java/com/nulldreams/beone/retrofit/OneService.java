package com.nulldreams.beone.retrofit;

import com.nulldreams.beone.module.Content;
import com.nulldreams.beone.module.MovieDetail;
import com.nulldreams.beone.module.MusicDetail;
import com.nulldreams.beone.module.OneList;
import com.nulldreams.beone.module.TextDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by gaoyunfei on 2017/1/31.
 */

public interface OneService {

    String TAIL = "?channel=wdj&version=4.0.2&platform=android";

    @GET("onelist/idlist/" + TAIL)
    Call<Result<int[]>> getIdList (@Query("uuid") String uuid);

    @GET("onelist/{id}/0" + TAIL)
    Call<Result<OneList>> getOneList (@Path("id") int id, @Query("uuid") String uuid);

    @GET("channel/reading/more/{last_id}" + TAIL)
    Call<Result<List<Content>>> getReadingList (@Path("last_id") int last_id, @Query("uuid") String uuid);

    @GET("channel/music/more/{last_id}" + TAIL)
    Call<Result<List<Content>>> getMusicList (@Path("last_id") int last_id, @Query("uuid") String uuid);

    @GET("channel/movie/more/{last_id}" + TAIL)
    Call<Result<List<Content>>> getMovieList (@Path("last_id") int last_id, @Query("uuid") String uuid);

    @GET("essay/{item_id}" + TAIL)
    Call<Result<TextDetail>> getTextDetail (@Path("item_id") int item_id, @Query("uuid") String uuid);

    @GET("music/detail/{item_id}" + TAIL)
    Call<Result<MusicDetail>> getMusicDetail (@Path("item_id") int item_id, @Query("uuid") String uuid);

    @GET("movie/{item_id}/story/1/0" + TAIL)
    Call<Result<MovieDetail>> getMovieDetail (@Path("item_id") int item_id, @Query("uuid") String uuid);
}
