package com.mega.mobile06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name"); // 홍길동
        int age = intent.getIntExtra("age", 0);
        double he = intent.getDoubleExtra("height", 0.0);
        String[] hobby = intent.getStringArrayExtra("hobby");
        ArrayList<String> abc = (ArrayList<String>)intent.getSerializableExtra("subject");

        //Toast.makeText(getApplicationContext(), "받은 이름은 : " + name, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), "받은 숫자는 : " + age, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(), "키는 : " + he, Toast.LENGTH_LONG).show();

        String list = "";
        for (String hobby2: hobby) {
            list += hobby2 + " ";
        }

        Toast.makeText(getApplicationContext(), "취미는 : " + list +"\n 과목 : " + abc, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "과목은 : " + abc, Toast.LENGTH_LONG).show();

    }
}