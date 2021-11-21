package com.app.mobile10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfectAdapter extends BaseAdapter {
    Context context;

    // 생성자를 만들어서 파라메터를 넣어줌
    PerfectAdapter(Context c) { // GridActivity2
        context = c;
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

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        // 반복되는 하나의 View객체를 만들어주어야 함.
//        Button button = new Button(context);
//        button.setText("버튼 글자야....");
//        return button;
        // 인플레이트
        View one = View.inflate(context, R.layout.one, null);
        TextView top = one.findViewById(R.id.topText);
        ImageView iv = one.findViewById(R.id.imageView8);

        one.setPadding(10, 10, 10, 10);
        one.setLayoutParams(new ViewGroup.LayoutParams(500,500));
        top.setText(title[index]);
        iv.setImageResource(posterID[index]);


        return one;
    }
}
