package com.nulldreams.beone.module;

import android.support.annotation.IntDef;
import android.text.TextUtils;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

/**
 * Created by gaoyunfei on 2017/1/31.
 */

public class Content implements Serializable{

    public static final int TYPE_IMAGE = 0,
            TYPE_ARTICLE = 1, TYPE_ESSAY = 2, TYPE_FAQ = 3,
            TYPE_MUSIC = 4, TYPE_MOVIE = 5;

    @IntDef({TYPE_IMAGE, TYPE_ARTICLE, TYPE_ESSAY, TYPE_MUSIC, TYPE_MOVIE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {}


    public int id, category, display_category,
            item_id, like_count, audio_platform,
            number, serial_id, movie_story_id, ad_id,
            ad_type, content_id,
            orientation;
    public @Type int content_type;
    public String title, forward, img_url, video_url,
            audio_url, start_video, volume, pic_info,
            words_info, subtitle, ad_pvurl, ad_linkurl,
            ad_makettime, ad_closetime, ad_share_cnt,
            ad_pvurl_vendor, share_url, content_bgcolor;
    public Date post_date, last_update_date;
    public ShareInfo share_info;
    public Answerer answerer;

    public boolean hasMusic () {
        return !TextUtils.isEmpty(audio_url) && audio_url.startsWith("http");
    }

}
