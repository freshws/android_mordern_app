package com.example.my_test.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.my_test.R;
import com.example.my_test.dto.Todo;
import com.example.my_test.util.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Todo todo = new Todo(1, "제목1");

        Util.spPut("todo__1__id", todo.getId());
        Util.spPut("todo__1__title", todo.getTitle());
        Util.spCommit();

        Todo todoFromSp = new Todo(Util.spGetInt("todo__1__id", 0), Util.spGetString("todo__1__title", ""));

        Util.toast("todoFromSp : " + todoFromSp.toString());

        /*
        Util.spPut("age", 11);
        Util.spPut("isMarried", false);
        Util.spCommit();

        int age = Util.spGetInt("age",0);
        boolean isMarried =Util.spGetBoolean("isMarried", false);

        Util.toast("나이 : " + age + ", 결혼 여부 : " + isMarried);
        */
    }
}