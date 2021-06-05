package com.example.my_test.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_test.R;
import com.example.my_test.dto.Todo;
import com.example.my_test.util.Util;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*
        // 아래 주석 처리된 구문들은 객체를 저장하는 구문이며
        // 1개 객체가 아닌 여러 객체를 저장할 수 있는 방법에 대한 것
        Todo todo1 = new Todo(1, "제목1");
        Todo todo2 = new Todo(2, "제목2");

        List<Todo> todos = new ArrayList<>();

        todos.add(todo1);
        todos.add(todo2);

        Util.spPut("todos", todos);
        Util.spCommit();
        */
        
        //아래의 "List.class"는 저장된 객체가 List 타입으로 저장되었기 때문에 불러 올 때도 List 타입으로 불러오는 것
        //즉 Json을 통해 거꾸로 데이터를 읽어올 때 어떤 형식으로 가져올지 지정해주는 것(역직렬화)
        //List<Todo> todos = Util.spGetObj("todos", List.class);

        //<List<Todo> 같은 paramerized type의 타입을 반환 받기 위해 new TypeReference<List<Todo>>(){} 를 사용
        List<Todo> todos = Util.spGetObj("todos", new TypeReference<List<Todo>>(){});

        //"todos.get(0).getId()"는 int 타입 이지만 "+ "번"" 적어주면 전제 문장이 String이 된다.
        Util.log(todos.get(0).getId() + "번");
        Util.log(todos.get(1).getId() + "번");
        
        Util.log(todos.get(0).getTitle());
        Util.log(todos.get(1).getTitle());

    }
}