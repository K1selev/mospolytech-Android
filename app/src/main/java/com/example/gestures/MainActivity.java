package com.example.gestures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_singl_act = (Button) findViewById(R.id.button_single_gesture);
        button_singl_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SingleGestureActivity.class);
                startActivity(intent);
            }
        });

        Button button_multi_touch_act = (Button) findViewById(R.id.button_multi_gesture);
        button_multi_touch_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MultiTouchActivity.class);
                startActivity(intent);
            }
        });
    }
}