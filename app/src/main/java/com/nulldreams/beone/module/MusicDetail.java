package com.nulldreams.beone.module;

import java.util.Date;

/**
 * Created by gaoyunfei on 2017/2/3.
 */

public class MusicDetail {
    public int id, praisenum, next_id, sharenum, commentnum;
    public String title, cover, isfirst,
            story_title, story, info, platform,
            music_id, charge_edt, related_to,
            web_url, hide_flag, sort, read_num,
            story_summary, audio, anchor, editor_email,
            related_musics, album, start_video, media_type,
            copyright, previous_id;
    public Date maketime, last_update_date;
    public Author author, story_author;
    public Author[] author_list;
    public ShareList share_list;
}
