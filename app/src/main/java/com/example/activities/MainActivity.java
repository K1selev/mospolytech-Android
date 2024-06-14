package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activities.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_next_act = (Button) findViewById(R.id.button_next_activity);

        TextView textview = (TextView) findViewById(R.id.textview);
        TextView textview_create = (TextView) findViewById(R.id.textview_create);
        TextView textview_start = (TextView) findViewById(R.id.textview_start);
        TextView textview_resume = (TextView) findViewById(R.id.textview_resume);
        TextView textview_pause = (TextView) findViewById(R.id.textview_pause);
        TextView textview_restart = (TextView) findViewById(R.id.textview_restart);
        TextView textview_stop = (TextView) findViewById(R.id.textview_stop);
        TextView textview_destroy = (TextView) findViewById(R.id.textview_destroy);
        String text_create  = getIntent().getStringExtra("button_create");
        String text_start  = getIntent().getStringExtra("button_start");
        String text_resume  = getIntent().getStringExtra("button_resume");
        String text_pause  = getIntent().getStringExtra("button_pause");
        String text_restart  = getIntent().getStringExtra("button_restart");
        String text_stop  = getIntent().getStringExtra("button_stop");
        String text_destroy  = getIntent().getStringExtra("button_destroy");
        String text  = getIntent().getStringExtra("button_clicked");
        if (text != null) {
            textview.setText(text);
        }
        if (text_create != null) {
            textview_create.setText(text_create);
        }
        if (text_start != null) {
            textview_start.setText(text_start);
        }
        if (text_resume != null) {
            textview_resume.setText(text_resume);
        }
        if (text_pause != null) {
            textview_pause.setText(text_pause);
        }
        if (text_restart != null) {
            textview_restart.setText(text_restart);
        }
        if (text_stop != null) {
            textview_stop.setText(text_stop);
        }
        if (text_destroy != null) {
            textview_destroy.setText(text_destroy);
        }

        button_next_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
