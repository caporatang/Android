package com.app.mobile08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView result;
    String timeTotal, dateTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("날짜, 시간 예약");

        //버튼  오브젝으로 btnStart로 위에서 넣어주는데 강제형 변환을 안해줘도
        // 툴에서 자동으로 해준다
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);

        //라디오 버튼 2개
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);

        //크로노미터
        chrono = findViewById(R.id.chronometer1);

        // 캘린더
        calView = findViewById(R.id.calendarView1);

        // 타임피커
        tPicker = findViewById(R.id.timePicker1);

        // 결과값 텍스트 뷰
        result = findViewById(R.id.result);

        // 시작할때 보이지 말아라
        calView.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 클릭했을때 보이게 해줄때는 비져블 ~
                calView.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calView.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 크로노미터는 버튼을 눌렀을 때를 베이스로 해서 시작하게 해야함
                chrono.setBase(SystemClock.elapsedRealtime());
                //타이머 시작
                chrono.start();
                chrono.setTextColor(Color.BLUE);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.RED);
                int hour = tPicker.getCurrentHour();
                int min = tPicker.getCurrentMinute();
                String timeTotal = hour + "시 " + min + "분";
                toast("현재시각 " + timeTotal);

                result.setText(dateTotal + " " + timeTotal);
            }
        }); // btnEnd end

        // 캘린더뷰 이벤트 처리
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override                                                                                    // 한달에 며칠쯤인지 전세계적으로 통일 시켜주기 위해 변수명 설정
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
               dateTotal = year + "년" + (month + 1) + "월" + dayOfMonth + "일";
                toast("가지고온 날짜는 " + dateTotal);
            }
        }); // calView end
    } //onCreate




    public void toast(String text){
        Toast.makeText(getApplicationContext(),
                text,
                Toast.LENGTH_SHORT).show();
    }



} // class end