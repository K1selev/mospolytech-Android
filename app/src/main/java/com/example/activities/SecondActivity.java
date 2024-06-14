package com.example.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Intent intent;
    private static final int CALL_PHONE_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        intent = new Intent(SecondActivity.this, MainActivity.class);

        Button button_prev_act = (Button) findViewById(R.id.button_back);
        intent.putExtra("button_create", "Activity onCreate");
        button_prev_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("button_clicked", "Button clicked");
                startActivity(intent);
            }
        });
        Button button_call = (Button) findViewById(R.id.button_call);
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission(android.Manifest.permission.CALL_PHONE,
                        CALL_PHONE_PERMISSION_CODE);
            }
        });
    }
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        intent.putExtra("button_start", "Activity onStart");
        Toast.makeText(SecondActivity.this,"ON START", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        intent.putExtra("button_resume", "Activity onResume");
        Toast.makeText(SecondActivity.this,"ON RESUME", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        intent.putExtra("button_pause", "Activity onPause");
        super.onPause();
        Toast.makeText(SecondActivity.this,"ON PAUSE", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        intent.putExtra("button_restart", "Activity onRestart");
        Toast.makeText(SecondActivity.this,"ON RESTART", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        intent.putExtra("button_stop", "Activity onStop");
        Toast.makeText(SecondActivity.this,"ON STOP", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        intent.putExtra("button_destroy", "Activity onDestroy");
        Toast.makeText(SecondActivity.this,"ON DESTROY", Toast.LENGTH_SHORT).show();
    }
    public void callPhone() {
        Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +
                "900"));
        startActivity(dialIntent);
    }
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(SecondActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(SecondActivity.this, new String[]
                    { permission }, requestCode);
        }
        else {
            callPhone();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions,
                grantResults);
        if (requestCode == CALL_PHONE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(SecondActivity.this,"Разрешение предоставлено",Toast.LENGTH_SHORT).show();
                        callPhone();
            }
            else {
                Toast.makeText(SecondActivity.this,"Разрешение отклонено",Toast.LENGTH_SHORT).show();
            }
        }
    }
}