package com.nulldreams.beone.module;

import java.util.Date;

/**
 * Created by gaoyunfei on 2017/2/3.
 */

public class TextDetail {
    public int content_id, next_id, praisenum, sharenum, commentnum;
    public String hp_title, sub_title, hp_author,
            auth_it, hp_author_introduce, hp_content,
            web_url, guide_word, hide_flag, wb_name,
            wb_img_url, audio, anchor, editor_email,
            top_media_type, top_media_file, top_media_image,
            start_video, copyright, previous_id;
    public Date hp_makettime, last_update_date, maketime;
    public Author[] author;
    public Author[] author_list;
    public ShareList share_list;

}
