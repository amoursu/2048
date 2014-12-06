package com.amoursu.g2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

/**
 * Created by zhouyan on 14/12/4.
 */
public class GameView extends GridLayout {

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initGameView();
    }

    public GameView(Context context) {
        super(context);
        initGameView();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGameView();
    }

    public void initGameView(){

        setColumnCount(4);
        setBackgroundColor(0xffbbada0);
        setOnTouchListener(new OnTouchListener(){
            private float startX,startY,offsetX,offsetY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        offsetX = event.getX() - startX;
                        offsetY = event.getY() - startY;
                        break;
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        break;
                }

                if(Math.abs(offsetX) > Math.abs(offsetY)){
                    if(offsetX < -5) {
                        //left
                        swipeLeft();
                    }
                    else if(offsetX > 5){
                        //right
                        swipeRight();
                    }
                }
                else{
                    if(offsetY < -5) {
                        //up
                        swipeUp();
                    }
                    else if(offsetY > 5){
                        //down
                        swipeDown();
                    }

                }

                return true;
            }
        });
    }

    private void swipeLeft(){

    }
    private void swipeRight(){

    }
    private void swipeUp(){

    }
    private void swipeDown(){

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int cardWidth = Math.min(w,h);
        addCard(cardWidth,cardWidth);

    }

    private void addCard(int cardWidth, int cardHeight){
        Card c;

        for(int y = 0;y < 4;y++){
            for(int x = 0;x < 4;x++){
                c = new Card(getContext());
                c.setNum(2);
                addView(c,cardWidth,cardHeight);
            }
        }


    }
}
