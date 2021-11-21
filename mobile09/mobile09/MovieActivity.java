package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        String[] title = {"더 랍스터", "디스 이즈 잇", "조커", "블랙", "화이트데이", "1917", "위플래쉬", "블랙펜서", "코로나"};
        int[] poster = {R.drawable.movie1, R.drawable.movie2, R.drawable.movie3,
                R.drawable.movie4, R.drawable.movie5, R.drawable.movie6, R.drawable.movie7, R.drawable.movie8, R.drawable.movie9};
        int[] vote = new int[9];
        TextView[] mt = new TextView[9];
        ImageView[] mp = new ImageView[9];

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
        for (int i = 0; i < movieTitle.length; i++) {
            final int i2 = i;
            mt[i] = findViewById(movieTitle[i]);
            mp[i] = findViewById(moviePoster[i]);
            mt[i].setText(title[i]);
            mp[i].setImageResource(poster[i]);

            mp[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vote[i2]++;
                }
            });
        }
        Button movieBtn;
        movieBtn = findViewById(R.id.movieBtn);
        movieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MovieActivity.this, MovieResult.class);
                intent2.putExtra("title", title);
                intent2.putExtra("vote", vote);
                intent2.putExtra("mp", poster);
                startActivity(intent2);


            }
        });
    }


}