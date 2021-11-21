package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class StarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);


        TabHost tabHost = findViewById(R.id.tabhost2);
        tabHost.setup(); // 기초적인 tab 초기화

        // 각 탭마다의 설정을 넣어줌.
        // 부품들을 하나씩 만든것임.
        TabHost.TabSpec tabHome = tabHost.newTabSpec("HOME").setIndicator("홈");
        tabHome.setContent(R.id.tabHome); // layout을 끼워넣음
        tabHost.addTab(tabHome);

        TabHost.TabSpec tabCategory = tabHost.newTabSpec("CATEGORY").setIndicator("카테고리");
        tabCategory.setContent(R.id.tabCategory);
        tabHost.addTab(tabCategory);

        TabHost.TabSpec tabGift = tabHost.newTabSpec("Gift").setIndicator("선물");
        tabGift.setContent(R.id.tabGift);
        tabHost.addTab(tabGift);

        //시작을 홈부터 하게 설정 Tab(인덱스값을 입력)
        tabHost.setCurrentTab(0);



    }
}