package com.nulldreams.beone.module;

import java.util.Date;

/**
 * Created by gaoyunfei on 2017/2/3.
 */

public class MovieDetail {
    public int count;
    public Data[] data;

    public class Data {
        public int praisenum;
        public String id, movie_id, title,
                content, sort, story_type,
                summary, audio, anchor, copyright,
                charge_edit, editor_email;
        public Date input_date;
        public Author user;
        public Author[] author_list;
    }
}
