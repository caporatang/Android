package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity5 extends AppCompatActivity {
    EditText t1, t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        t1 = findViewById(R.id.title);
        t2 = findViewById(R.id.content3);
        b1 = findViewById(R.id.save2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = t1.getText().toString();
                String content = t2.getText().toString();
                try {
                 FileOutputStream file = openFileOutput("" + title + ".txt", MODE_PRIVATE);
                    file.write(content.getBytes(StandardCharsets.UTF_8));
                    file.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



    }
}