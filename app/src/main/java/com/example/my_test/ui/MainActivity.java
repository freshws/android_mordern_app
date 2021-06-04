package com.example.my_test.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_test.R;
import com.example.my_test.dto.Todo;
import com.example.my_test.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Todo todo1 = new Todo(1, "제목1");
        Todo todo2 = new Todo(2, "제목2");

        List<Todo> todos = new ArrayList<>();

        todos.add(todo1);
        todos.add(todo2);

        Util.spPut("todos", todos);
        Util.spCommit();

        String jsonString = Util.spGetString("todos", "");

        Util.log(jsonString);


    }
}