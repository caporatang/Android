package com.app.mobile10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridAdapter extends BaseAdapter {
    Context context; //액티비티를 값이 들어갈 객체!

    MyGridAdapter(Context context1){
        context = context1;
    }
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
    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //gridView에 들어갈 하나하나의 layout을 만들어주는 메서드!
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //gridView에 들어갈 이미지뷰 객체를 만들어주어야 한다.
//        ImageView imageView = new ImageView(context);
//        imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
//        imageView.setPadding(5, 5, 5, 5);
//        // Button button = new Button(context);
//        imageView.setImageResource(posterID[i]);
//        return imageView;

//        TextView text = new TextView(context);
//        text.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
//        text.setPadding(5,5,5,5);
//        text.setText("안드로이드 어려워@@");
//        return text;

        Button button = new Button(context);
        button.setLayoutParams(new ViewGroup.LayoutParams(500,500));
        button.setPadding(10,10,10,10);
        button.setText("안드로이드 너무 어려웡,...");
        return button;




    }
//기본 어탭터의 기능들을 내가 임의로 재정의해서 사용가능하다.


}