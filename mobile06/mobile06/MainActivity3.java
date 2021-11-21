package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity3 extends AppCompatActivity {
    EditText text1,text2;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        save = findViewById(R.id.save2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = text1.getText().toString();
                String content = text2.getText().toString();

                // 파일에 저장하기
                Toast.makeText(getApplicationContext(), "날짜는 : " + date + "내용은" + content, Toast.LENGTH_SHORT).show();
                try {
                    FileOutputStream file = openFileOutput("" + date +".txt", MODE_PRIVATE); // 사용자만 저장 가능
                    String data = "i am a android programmer...";
                    //파일에 전송할때 1바이트씩 전송해야 하므로 바이트로 컨버팅 시켜서 넣어야함
                    file.write(content.getBytes(StandardCharsets.UTF_8));
                    file.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace(); // 파일 저장할때 발생한 에러
                    Log.d("","파일이 존재하지 않습니다");
                } catch (IOException e) {
                    e.printStackTrace(); // 파일 작성시에 발생한 에러
                    Log.d("","파일을 읽고 쓰는 중에 에러가 발생했습니다");
                } catch (Exception e) {
                    Log.d("","에러가 발생 했어요");
                }

            }
        });



    }
}