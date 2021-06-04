package com.example.my_test.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_test.R;
import com.example.my_test.dto.Todo;
import com.example.my_test.util.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        Todo todo = new Todo(1, "제목1");
        Util.spPut("todo1", todo);
        Util.spCommit();
*/
        Todo todoResult = Util.spGetObj("todo1", Todo.class);

        //저장된 메세지가 없으면 아래 문장이 에러는 아니지만 문제를 발생 시킴
        //그래서 먼저 spPut() 메소드를 통해 객체를 저장해야 됨.
        Util.toast((String)todoResult.toString());




    }
}