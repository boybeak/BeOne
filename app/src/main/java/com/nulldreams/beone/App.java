package com.nulldreams.beone;

import android.app.Application;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by gaoyunfei on 2017/2/8.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {

            }
        });
    }
}
