package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
        EditText t1, t2;
        Button b1;
        TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        b1 = findViewById(R.id.b1);
        t3 = findViewById(R.id.text3);
//        String id = t1.getText().toString();
//        String pw = t2.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = t1.getText().toString();
                String pw = t2.getText().toString();
                if (id.equals("root") & pw.equals("pw")){
                    t3.setText("로그인 성공");
                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(intent);
                } else{
                    t3.setText("로그인 실패");
                }
            }
        });










    }
}