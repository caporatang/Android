package com.mega.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login, join;
    EditText id, pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login); // 로그인 버튼
        join = findViewById(R.id.join); // 회원가입 버튼
        id = findViewById(R.id.id); // 아이디 입력칸
        pw = findViewById(R.id.pw); // 아이디 입력칸

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "회원가입 페이지로 이동 합니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String mail = intent.getStringExtra("mail");
                String pwJoin = intent.getStringExtra("pwJoin");
                String loginId = id.getText().toString();
                String loginPw = pw.getText().toString();

                if(!loginId.equals(mail) || !loginPw.equals(pwJoin)){
                    Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 확인 해주세요", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "" + loginId + "님 환영합니다^..^", Toast.LENGTH_SHORT).show();
                }





            }
        });



    }
}