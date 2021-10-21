package com.mega.practiceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText email, emailConfirm, joinPw, pwConfirm;
    Button joinButton;
    TextView setPw, setEmail;
    CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.email); // 이메일 입력
        emailConfirm = findViewById(R.id.emailConfirm); // 중복확인
        joinPw = findViewById(R.id.joinPw); // pw입력
        pwConfirm = findViewById(R.id.pwConfirm);// pw 중복확인
        joinButton = findViewById(R.id.joinButton); // 회원가입 페이지 가입하기버튼
        setEmail = findViewById(R.id.setEmail); // email 중복확인용 텍스트 뷰
        setPw = findViewById(R.id.setPw);// pw 중복확인용 텍스트 뷰
        check = findViewById(R.id.checkBox);

        joinButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String mail = email.getText().toString(); // 로그인 페이지로 넘기자 이메일
                String mailConfirm = emailConfirm.getText().toString();
                String pwJoin = joinPw.getText().toString(); // 로그인 페이지로 넘기자 비밀번호
                String confirmPw = pwConfirm.getText().toString();

                if (!mail.equals(mailConfirm) || !mail.contains("@")) {
                    setEmail.setText("이메일을 확인 해주세요");
                    setPw.setText("");
                } else if (!pwJoin.equals(confirmPw) || pwJoin.length() < 8) {
                    setPw.setText("비밀번호를 확인 해주세요");
                    setEmail.setText("");
                } else if (check.isChecked() == false) {
                    setEmail.setText("");
                    setPw.setText("");
                    Toast.makeText(getApplicationContext(), "약관을 확인 해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "회원가입이 완료 되었습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    intent.putExtra("mail", mail);
                    intent.putExtra("pwJoin", pwJoin);
                    startActivity(intent);
                }
            }
        });
    }

}


