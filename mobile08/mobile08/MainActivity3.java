package com.app.mobile08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
       Intent intent = getIntent();
       String time = intent.getStringExtra("timeTotal");
       String day = intent.getStringExtra("date");


        Toast.makeText(getApplicationContext(), "넘어온 날짜와 시간은 " + day + "  " + time, Toast.LENGTH_SHORT).show();


    }
}