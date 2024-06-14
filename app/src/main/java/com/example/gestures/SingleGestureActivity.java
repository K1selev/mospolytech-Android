package com.example.gestures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleGestureActivity extends AppCompatActivity {
    private GestureDetectorCompat myDetector;
    TextView myText;
    View myView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_gesture);
        myText = findViewById(R.id.myText);
        myView = findViewById(R.id.myView);
        Button button_prev_act = (Button) findViewById(R.id.button_back);
        button_prev_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleGestureActivity.this, MainActivity.class);
//                intent.putExtra("button_clicked", "Button clicked");
                startActivity(intent);
            }
        });
        GestureListener myGestures = new GestureListener();
        myDetector = new GestureDetectorCompat(this, myGestures);
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myDetector.onTouchEvent(event);
            }
        });
        myDetector.setOnDoubleTapListener(myGestures);
    }

    public class GestureListener implements
            GestureDetector.OnGestureListener,
            GestureDetector.OnDoubleTapListener {
        @Override
        public boolean onDown(MotionEvent event) {
            myText.append("\n onDown");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            myText.append("\n onFling");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent event) {
            myText.append("\n onLongPress");
        }

        @Override
        public boolean onScroll(MotionEvent event1, MotionEvent event2,
                                float distanceX, float distanceY) {
            myText.append("\n onScroll");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent event) {
            myText.append("\n onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            myText.append("\n onSingleTapUp");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent event) {
            myText.append("\n onDoubleTap");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent event) {
            myText.append("\n onDoubleTapEvent");
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {
            myText.append("\n onSingleTapConfirmed");
            return true;
        }
    }
}