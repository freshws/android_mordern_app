package com.example.my_test;

import android.app.Application;

import com.example.my_test.util.Util;
import com.facebook.stetho.Stetho;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Util.init(this);

        //stetho 초기화 문구
        Stetho.initializeWithDefaults(this);

    }
}
