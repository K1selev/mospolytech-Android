package com.example.gestures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnTouchListener;

public class MultiTouchActivity extends AppCompatActivity implements OnTouchListener {
    int upIndex = 0;
    int downIndex = 0;
    boolean touchFlag = false;
    TextView[] idView = new TextView[10];
    TextView[] xView = new TextView[10];
    TextView[] yView = new TextView[10];
    TextView myText;
    View myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_touch);
        Button button_prev_act = (Button) findViewById(R.id.button_back);
        button_prev_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiTouchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        myView = findViewById(R.id.myView_multi);
        myText = findViewById(R.id.myText_multi);
        String myPackage = getPackageName();
        Resources myResources = getResources();
        for (int i = 0; i < 10; i++) {
            idView[i] = findViewById(myResources.getIdentifier("id"+i, "id",
                    myPackage));
            xView[i] = findViewById(myResources.getIdentifier("x"+i, "id",
                    myPackage));
            yView[i] = findViewById(myResources.getIdentifier("y"+i, "id",
                    myPackage));
        }
        for (int i = 0; i < 10; i++) {
            idView[i].setText("");
            xView[i].setText("");
            yView[i].setText("");
        }
        myView.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int actionMask = event.getActionMasked();
        int pointerIndex = event.getActionIndex();
        int pointerCount = event.getPointerCount();
        switch (actionMask) {
            case MotionEvent.ACTION_DOWN:
                touchFlag = true;
            case MotionEvent.ACTION_POINTER_DOWN:
                downIndex = pointerIndex;
                break;
            case MotionEvent.ACTION_UP:
                touchFlag = false;
                for (int i = 0; i < 10; i++) {
                    idView[i].setText("");
                    xView[i].setText("");
                    yView[i].setText("");
                    myText.setText("Координаты касаний");
                }
            case MotionEvent.ACTION_POINTER_UP:
                upIndex = pointerIndex;
                break;
            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < 10; i++) {
                    idView[i].setText("");
                    xView[i].setText("");
                    yView[i].setText("");
                    if (i < pointerCount) {
                        idView[i].setText(Integer.toString(event.getPointerId(i)));
                        xView[i].setText(Integer.toString((int)event.getX(i)));
                        yView[i].setText(Integer.toString((int)event.getY(i)));
                    } else {
                        idView[i].setText("");
                        xView[i].setText("");
                        yView[i].setText("");
                    }
                }
                break;
        }
        if (touchFlag) {
            myText.setText("Количество касаний: " +
                    Integer.toString(pointerCount) + "\n" + "Индекс последнего касания: " +
                    downIndex + "\n" + "Индекс последнего отпускания: " + upIndex );
        }
        return true;
    }
}