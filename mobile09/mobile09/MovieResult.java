package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_result);

        Intent intent2 = getIntent();
        String[] title = intent2.getStringArrayExtra("title");
        int[] vote = intent2.getIntArrayExtra("vote");
        int[] mp = intent2.getIntArrayExtra("mp");
        TextView[] tv = new TextView[title.length];
        ImageView[] img = new ImageView[mp.length];


        int[] movieTitle = {
                R.id.tv1,
                R.id.tv2,
                R.id.tv3,
                R.id.tv4,
                R.id.tv5,
                R.id.tv6,
                R.id.tv7,
                R.id.tv8,
                R.id.tv9
        };

        int[] moviePoster = {
                R.id.img1,
                R.id.img2,
                R.id.img3,
                R.id.img4,
                R.id.img5,
                R.id.img6,
                R.id.img7,
                R.id.img8,
                R.id.img9
        };

        for (int i = 0; i < tv.length; i++) {
            tv[i] = findViewById(movieTitle[i]);
            img[i] = findViewById(moviePoster[i]);
            tv[i].setText(title[i] + " " + vote[i]);
            img[i].setImageResource(mp[i]);

        }


    }
}