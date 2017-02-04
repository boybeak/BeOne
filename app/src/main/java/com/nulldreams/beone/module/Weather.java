package com.nulldreams.beone.module;

import java.util.Date;

/**
 * Created by gaoyunfei on 2017/1/31.
 */

public class Weather {
    public String city_name, climate, wind_direction, hurricane;
    public Date date;
    public int temperature, humidity;
    public Icon icons;

    public class Icon {
        public String day, night;
    }
}
