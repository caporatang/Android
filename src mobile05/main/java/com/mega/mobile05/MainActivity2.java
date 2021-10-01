package com.mega.mobile05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button b4, b5, b6;
    EditText t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        t1 = findViewById(R.id.t1);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Str = t1.getText().toString();
                String site = "http://www." + Str + ".com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
                startActivity(intent);
            }
        });




        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity2.this);
                dlg.setTitle("맛집 리스트");
                String[] foodList = new String[] {"7번가피자", "곱창이야기", "진돈부리"};
                dlg.setItems(foodList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        if(i == 0){
//                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/1850252387/location?subtab=location"));
//                            startActivity(intent);
//                        } else if (i == 1){
//                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/1088886581/location?subtab=location"));
//                            startActivity(intent);
//                        } else if (i == 2){
//                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.place.naver.com/restaurant/1674726200/location?subtab=location"));
//                            startActivity(intent);
//                        }
                        String site = "https://m.map.naver.com/search2/search.naver?query=" + foodList[i] + "#/map/";
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
                        startActivity(intent);



                    }
                });
                dlg.show();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}