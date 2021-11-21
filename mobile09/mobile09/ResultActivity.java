package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("영화 선호도 투표 결과");

        Intent intent = getIntent();
        String[] imgName = intent.getStringArrayExtra("imgName");
        int[] voteCount = intent.getIntArrayExtra("voteCount");

        TextView[] tv = new TextView[imgName.length];
        RatingBar[] rbar = new RatingBar[imgName.length];
        int[] tvId = {
                R.id.tv1,
                R.id.tv2,
                R.id.tv3,
                R.id.tv4,
                R.id.tv5,
                R.id.tv6,
                R.id.tv7,
                R.id.tv8,
                R.id.tv9,
        };
        int[] rbatId = {
                R.id.rbat1,
                R.id.rbat2,
                R.id.rbat3,
                R.id.rbat4,
                R.id.rbat5,
                R.id.rbat6,
                R.id.rbat7,
                R.id.rbat8,
                R.id.rbat9,
        };
        for (int i=0; i< imgName.length; i++){
        tv[i] = findViewById(tvId[i]);
        rbar[i] = findViewById(rbatId[i]);

        tv[i].setText(imgName[i]);
        rbar[i].setRating(voteCount[i]);

        } // for end
        Button btnReturn;
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    } // onCreate
} // class end