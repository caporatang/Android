package com.app.mobile10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class GridActivity extends AppCompatActivity {
    int[] count = new int[9]; // 투표수

    int[] posterID = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.er
    };
    String[] title = {
            "그림1",
            "그림2",
            "그림3",
            "그림4",
            "그림5",
            "그림6",
            "그림7",
            "그림8",
            "그림9",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_background);
        setTitle("그리드뷰 영화 포스");
        //그리드 뷰에, 데이터들을 넣어보자.!
        //그리드 뷰
        GridView gv = findViewById(R.id.gridView1);

        //데이터들
        // MyGridAdapter gridAdapter = new MyGridAdapter(this);
        // gv.setAdapter(gridAdapter);

        //PerfectAdapter에서 만든 context를 입력값으로 넣어주어야 한다.
        // c : this는 PerfectAdapter에서 만든 context 변수이다. 여기에 만든 그리드를 얹을거야 라는 의미이다.
        PerfectAdapter perfectAdapter = new PerfectAdapter(this);
        gv.setAdapter(perfectAdapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                count[index]++;

               int vote = count[index];

                View alert = View.inflate(getApplicationContext(),R.layout.onetwo,null);
                ImageView topiv = alert.findViewById(R.id.topImageView);
                EditText num = alert.findViewById(R.id.likenum);
                Button likebutton = alert.findViewById(R.id.likebutton);



                AlertDialog.Builder builder = new AlertDialog.Builder(GridActivity.this);
                builder.setView(alert);
                topiv.setImageResource(posterID[index]);
                builder.setTitle("영화 상세페이지");
                builder.setPositiveButton("확인",null);
                builder.show();


                likebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 입력한 숫자를 가지고와서, 해당 인덱스의 값과 더한 후 다시 넣어주세요.
                        // 해당 인덱스의 값이 증가했는지 띄워주세요

                        String num2 = num.getText().toString();
                        int num3 = Integer.parseInt(num2);

                        count[index] += num3;
                        Toast.makeText(getApplicationContext(),  count[index] + " 만큼 표를 받았어요", Toast.LENGTH_LONG).show();
                        num.setText(count[index] + "표");

                    }
                });





            }
        });

    }

    //기본 adapter는 arraylist, array의 데이터를 순서대로 넣어주는 기능만 있음.
    //데이터 하나 하나의 배치모양을 내가 정해서 어댑팅할 수 있음.
}