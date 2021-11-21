package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter2);
        setTitle("리스트뷰를 배워보자");
        //많은 양의 데이터를 view에 넣어주는 것을 adapter라고 부른다.
        // 많은 양의 데이터를 리스트에 담아서 준비 해놓자
        ArrayList<String> mid = new ArrayList<>();

        // jdk 1.8버전 ,이전 버전과 달라진 점?
        // 1) 제너릭(generic, general) 프로그램이 추가되었음
        // 클래스를 만들 때 특정한 데이터 타입을 지정하지 않았다가, 객체를 생성할때
        // 특정 데이터 타입을 지정해서 사용할 수 있는 프로그램
        mid.add("히어로즈");
        mid.add("24시");
        mid.add("로스트");
        mid.add("빅뱅이론");

        //view를 준비, ListView
        ListView listView1 = findViewById(R.id.listView1);


        // adapter부품이 필요하다 객체생성
                                        // 그냥 객체를 생성하면 기본생성자가 없어서 에러가남
                                        // 입력값이 있어야함
        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mid);

        //listView에 adapter를 세팅
        listView1.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                mid.add(data);
                // 어댑터를 갱신(새로고침)
                adapter.notifyDataSetChanged();
            }
        });// button end
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                String data = mid.get(index);
                Toast.makeText(getApplicationContext(), data + " " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}