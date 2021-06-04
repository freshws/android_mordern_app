package com.example.my_test.util;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.example.my_test.dto.Todo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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

    public static void spPut(String key, Object obj) {

        //SharedPreferences는 객체를 저장 할 수 없으니 우선 Jackson(Jason)을 통해 객체를 String으로 변환
        //String으로 변환한 값을 다시 SharedPreferences에 적용 하여 저장
        // ▶ 객체 자체로 저장할 수 없지만 변환하여 저장 하도록 해줌
        spPut(key, objToJsonString(obj));

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

    public static void log(String msg) {

        Log.d("AA1", msg);

    }

    public static String objToJsonString(Object obj) {
        ObjectMapper om = new ObjectMapper();

        try {
            return om.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "";
        }


    }


    public static <T> T spGetObj(String key, Class<T> cls) {

        String jsonString = spGetString(key, "");

        ObjectMapper om = new ObjectMapper();

        try {
            return (T) om.readValue(jsonString, cls);
        } catch (JsonProcessingException e) {
            return null;
        }


    }
}
