package com.example.my_test;

import android.app.Application;

import com.example.my_test.util.Util;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Util.init(this);

    }
}
