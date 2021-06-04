package com.example.my_test.util;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Util {

    private static Application application;
    private static SharedPreferences sp;
    private static SharedPreferences.Editor spEditor;

    public static void init(Application application) {

        Util.application = application;

        sp = PreferenceManager.getDefaultSharedPreferences(application);
        spEditor = sp.edit();

    }

    public static void toast(String msg) {

        Toast.makeText(application, msg, Toast.LENGTH_SHORT).show();

    }

    public static void spPut(String key, int value) {

        spEditor.putInt(key, value);

    }

    public static void spPut(String key, boolean value) {

        spEditor.putBoolean(key, value);

    }

    public static void spPut(String key, String value) {

        spEditor.putString(key, value);

    }

    public static void spCommit() {

        spEditor.commit();

    }

    public static int spGetInt(String key, int defaultValue) {

        return sp.getInt(key, defaultValue);

    }

    public static boolean spGetBoolean(String key, boolean defaultValue) {

        return sp.getBoolean(key, defaultValue);

    }

    public static String spGetString(String key, String defaultValue) {

        return sp.getString(key, defaultValue);

    }

}
