package com.app.mobile08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button start, end, day, time, next;
    Chronometer chronometer1;
    TimePicker timePicker1;
    CalendarView calendarView;
    String date, timeTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("날짜와 시간을 넘겨요");

        start = findViewById(R.id.start1);
        end = findViewById(R.id.end1);
        day = findViewById(R.id.day);
        time = findViewById(R.id.time);
        next = findViewById(R.id.next);
        chronometer1 = findViewById(R.id.chronometer1);
        timePicker1 = findViewById(R.id.timePicker1);
        calendarView = findViewById(R.id.calendarView);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.stop();
            }
        });

        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                       date = year + "년" + (month + 1) + "월" + dayOfMonth + "일";
                        toast("날짜는 : "  + date);

                    }
                }); // date change
            }
        }); // day set on click


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = timePicker1.getCurrentHour();
                int min = timePicker1.getCurrentMinute();
                timeTotal = hour + "시 " + min + "분";
                toast("현재시각 " + timeTotal);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("timeTotal", timeTotal);
                intent.putExtra("date", date);
                startActivity(intent);

            }
        });


    }// on create

    public void toast(String text){
        Toast.makeText(getApplicationContext(),
                text,
                Toast.LENGTH_SHORT).show();
    }

} // class