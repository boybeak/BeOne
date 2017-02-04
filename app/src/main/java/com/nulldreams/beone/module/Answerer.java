package com.nulldreams.beone.module;

import java.io.Serializable;

/**
 * Created by gaoyunfei on 2017/2/1.
 */

public class Answerer implements Serializable{
    public int user_id;
    public String user_name, desc, wb_name,
            summary, web_url, is_settled,
            settled_type, fans_total;
}
