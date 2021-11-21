package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 부모 클래스의 있는 메서드를 호출할때 super를 이용한다
        // 오버라이드 했기 때문에 부모를 호출하지 않으면 부모에 있는 클래스들은 실행할수없음
        // 액티비티의 기본틀 설정, 제목 , 기본색 설정
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button2);

        // 불완전하기 때문에 완벽하게 메서드를 정의해야 사용가능.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 액티비티를 넘기고, 데이터까지 같이 보내려고함
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", "홍길동");
                intent.putExtra("age", 100);
                intent.putExtra("height",100.2);

                String[] hobby = {"놀기","자기","유튜브"};
                intent.putExtra("hobby", hobby);


                ArrayList<String> subject = new ArrayList<>();
                subject.add("컴퓨터");
                subject.add("영어");
                subject.add("수학");
                subject.add("스포츠");

                intent.putExtra("subject", subject);


                startActivity(intent);


            }
        });



    }
}