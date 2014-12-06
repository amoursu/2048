package com.amoursu.g2048;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by zhouyan on 14/12/4.
 */
public class Card extends FrameLayout {

    public Card(Context context) {
        super(context);

        label = new TextView(getContext());
        label.setTextSize(32);
        label.setGravity(Gravity.CENTER);

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(-1,-1);
        addView(label, lp);

        setNum(0);
    }

    private int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num){
        this.num = num;

        label.setText(num+"");
    }

    public boolean equals(Card c) {
        return getNum() == c.getNum();
    }

    private TextView label;
}
