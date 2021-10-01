package com.mega.mobile05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //전역변수 선언 자동 초기화 글로벌 변수
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //만든 버튼을 가져와서 선언한 전역변수에 넣기
        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // AlertDialog는 inner 클래스 이다
//                // 클래스 안에 클래스를 끼우는 것을 inner클래스라고 한다
//                // AlertDialog < 안에 builder 클래스를 끼운다
//                Log.d("", "버튼1번을 클릭 했어요");
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); // 객체 생성
//                dlg.setTitle("@확인을 꼭 해주세요@");
//                //dlg.setMessage("@@@ 버튼을 눌렀기 때문에 내가 떴음 @@@"); // 객체에 띄워줄 메세지 셋팅
//
//                //배열과 메세지는 같이 사용할수 없음
//                //리스트를 띄워줄때는 배열을 생성하여 배열로 넣어주어야함
//                String[] versionArray = new String[]{"naver", "google", "nate", "daum"};
//                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Log.d("", "선택한 인덱스는 + " + i + ">>>>" + versionArray[i]);
//
//                        String pre = "http://www.";
//                        String post = ".com";
//                        if(versionArray[i].equals("daum")) {
//                            post = ".net";
//                        }
//                        String site = pre + versionArray[i] + post;
//                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
//                        startActivity(intent);
//                    }
//                });
//                dlg.setIcon(R.mipmap.ic_launcher); // 아이콘 넣기 R로 접급 해야함.
//                dlg.setPositiveButton("확인", null); // 버튼에 텍스트 넣기 , Null은 행동을 정하지 않음
//                dlg.show(); // 셋팅한 부품을 보여줌
//            } // onclick 메서드
//        });// button1 setOnClickListener

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // AlertDialog는 inner 클래스 이다
                // 클래스 안에 클래스를 끼우는 것을 inner클래스라고 한다
                // AlertDialog < 안에 builder 클래스를 끼운다
                Log.d("", "버튼1번을 클릭 했어요");
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); // 객체 생성
                dlg.setTitle("@확인을 꼭 해주세요@");
                //dlg.setMessage("@@@ 버튼을 눌렀기 때문에 내가 떴음 @@@"); // 객체에 띄워줄 메세지 셋팅
                //배열과 메세지는 같이 사용할수 없음
                //리스트를 띄워줄때는 배열을 생성하여 배열로 넣어주어야함
                String[] versionArray = new String[]{"오레오", "파이", "큐"};
                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("", "선택한 인덱스는 + " + i + ">>>>" + versionArray[i]);

//                        String pre = "http://www.";
//                        String post = ".com";
//                        if(versionArray[i].equals("daum")) {
//                            post = ".net";
//                        }
//                        String site = pre + versionArray[i] + post;
//                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
//                        startActivity(intent);
//                    }
//                });
                        String data = versionArray[i];
                        String site = "https://kin.naver.com/search/list.naver?query=" + data;
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
                        startActivity(intent);
                    }
                });
                dlg.setIcon(R.mipmap.ic_launcher); // 아이콘 넣기 R로 접급 해야함.
                dlg.setPositiveButton("확인", null); // 버튼에 텍스트 넣기 , Null은 행동을 정하지 않음
                dlg.show(); // 셋팅한 부품을 보여줌

            } // onclick 메서드
        });// button1 setOnClickListener

//            button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//                dlg.setTitle("자주가는 사이트");
//                String[] arr = new String[]{"네이버","구글","다음 카페","유튜브","페이스북"};
//                dlg.setItems(arr, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Log.d("","선택한 인덱스는 + " + arr[i]);
//                        if (arr[0].equals("네이버")){
//                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
//                            startActivity(intent);
//                        }
//                    }
//                });
//                dlg.setIcon(R.mipmap.ic_launcher);
//                dlg.setPositiveButton("갑시다", null);
//                dlg.show();
//            } // onclick 메서드
//        }); // button2 setOnClickListener


//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//                dlg.setTitle("고래 입니다");
//                dlg.setMessage("'______________________________________'\n 고래 좋아하세요 ?");
//                dlg.setIcon(R.mipmap.whale);
//                dlg.setPositiveButton("네 ", null);
//                dlg.setNegativeButton("아니요", null);
//                dlg.show();
//            } // onclick 메서드
//        }); // button2 setOnClickListener
    }
}


