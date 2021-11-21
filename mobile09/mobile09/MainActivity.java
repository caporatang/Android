package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar1, ratingBar2, ratingBar3;
    Button button1, button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ratingBar1 = findViewById(R.id.ratingBar1);
        ratingBar2 = findViewById(R.id.ratingBar2);
        ratingBar3 = findViewById(R.id.ratingBar3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ratingBar1.setRating(ratingBar1.getRating() + ratingBar1.getStepSize());
                    ratingBar2.setRating(ratingBar1.getRating() + ratingBar2.getStepSize());
                    ratingBar3.setRating(ratingBar1.getRating() + ratingBar3.getStepSize());
                }
            }); // 증가 버튼 end

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ratingBar1.setRating(ratingBar1.getRating() - ratingBar1.getStepSize());
                    ratingBar2.setRating(ratingBar1.getRating() - ratingBar2.getStepSize());
                    ratingBar3.setRating(ratingBar1.getRating() - ratingBar3.getStepSize());
                }
            });

    }
}