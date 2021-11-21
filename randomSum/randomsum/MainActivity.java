package com.aaa.randomsum;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    TextView textView, se1, se2, se3, se4;
    String number, text;

    int rere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.viewText);
        bt1 = findViewById(R.id.bt1);
        se1 = findViewById(R.id.se1);
        se2 = findViewById(R.id.se2);
        se3 = findViewById(R.id.se3);
        se4 = findViewById(R.id.se4);
        //랜덤
        Random r = new Random();

        ArrayList<Integer> arr = new ArrayList<>();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st = "start";
                String re = "restart";

                if (bt1.getText().toString().equals(st)){

                    rere = r.nextInt(6) + 1;
                    number = Integer.toString(rere); // to String
                    arr.add(rere); //배열에 int add
                    textView.setText(number); // 텍스트뷰 set
                    bt1.setText("stop"); // 버튼 텍스트 스탑으로 바꿔라 .

                }else if(bt1.getText().toString().equals("stop")){  // stop 일떄.

                    for (int i = 0; i < arr.size(); i++){
                        if (arr.get(i) == null){    // 어레이에 순차적으로 넣는 코드.
                            arr.add(rere);
                        }//if
                    }//for

                    Log.d("name", "어레이 값 : " + arr.toString());
                    bt1.setText("start"); // 버튼 start 변환

                    if (arr.size() == 1){   // 어레이 사이즈 1 일떄 1번 텍스트만 바꿔라 .
                        se1.setText(Integer.toString(arr.get(0)));
                    }else if(arr.size() == 2){
                        se2.setText(Integer.toString(arr.get(1)));
                    }else if(arr.size() == 3){
                        se3.setText(Integer.toString(arr.get(2)));
                    }else if(arr.size() == 4){
                        se4.setText(Integer.toString(arr.get(3)));
                    }

                    if (arr.size() == 4){   // 어레이 사이즈가 4일 때 버튼 텍스트 변경.
                        bt1.setText("restart");
                        int resultNum = 0;

                        for (int i =0; i < arr.size(); i++){ // 상단의 view 에 set
                            resultNum += arr.get(i);
                            text = Integer.toString(resultNum);
                        }//for
                        textView.setText("총합은 : " + text);
                    } // if --> 총합 더하는 if 문

                } else if(bt1.getText().toString().equals("restart")) {
                    arr.clear();
                    se1.setText("");
                    se2.setText("");
                    se3.setText("");
                    se4.setText("");

                    Log.d("name", "array 초기화 : " + arr.toString());

                    textView.setText("다시 시작");
                    rere = r.nextInt(6) + 1;
                    number = Integer.toString(rere); // to String
                    arr.add(rere); //배열에 int add
                    textView.setText(number); // 텍스트뷰 set
                    bt1.setText("stop");
                }
            }
        });
    } //main
}//class