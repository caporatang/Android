package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //어디에 분리시켜놓은 layout파일을 넣을지 결정!
        LinearLayout layout1 = findViewById(R.id.tabSong);
        LinearLayout layout2 = findViewById(R.id.tabArtist);
        LinearLayout layout3 = findViewById(R.id.tabAlbum);

        // 분리 시켜놓은 xml파일(layout)들을 객체화 시키자..!
        // inflation
        View songView = View.inflate(TabActivity.this, R.layout.song, null);
        View artView = View.inflate(TabActivity.this, R.layout.art, null);
        View albumView = View.inflate(TabActivity.this, R.layout.album, null);

        layout1.addView(songView);
        layout2.addView(artView);
        layout3.addView(albumView);

        // 인플레이션으로 끼워넣었을경우 끼워 넣은 페이지에 있는 객체를 사용할 경우에는
        // 끼워준 view에서 찾아야 한다.
        Button btnChange1 = songView.findViewById(R.id.btnChange);
        ImageView imageView1 = songView.findViewById(R.id.imageView);

        btnChange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView1.setImageResource(R.drawable.key);
            }
        });


        Button btnChange2 = artView.findViewById(R.id.btnChange2);
        ImageView imageView2 = artView.findViewById(R.id.imageView2);
        TextView textView = artView.findViewById(R.id.text4);

        btnChange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("@@@@ 텍스트가 나로 바뀐다 @@@@");
                imageView2.setImageResource(R.drawable.key);
            }
        });











        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup(); // 기초적인 tab 초기화

        // 각 탭마다의 설정을 넣어줌.
        // 부품들을 하나씩 만든것임.
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong); // layout을 끼워넣음
        tabHost.addTab(tabSpecSong);

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        //시작을 뮤직부터 하게 설정 Tab(인덱스값을 입력)
        tabHost.setCurrentTab(0);


    }
}