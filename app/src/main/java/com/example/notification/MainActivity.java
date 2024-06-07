package com.example.notification;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    int notificationId = 1;
    String CHANNEL_ID = "my_channel_01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_toast = (Button) findViewById(R.id.button_toast);
        Button button_status_bar = (Button) findViewById(R.id.button_status_bar);
        Button button_alert_dialog = (Button) findViewById(R.id.button_alert_dialog);

        button_toast.setOnClickListener(this);
        button_status_bar.setOnClickListener(this);
        button_alert_dialog.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int but = v.getId();
        if (but == R.id.button_toast) {
//            Log.d("1", "This is button toast");
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup) findViewById(R.id.Toast_Layout));
            TextView text = (TextView) layout.findViewById(R.id.textView);
            text.setText(R.string.toast_notif);
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
        if (but == R.id.button_status_bar) {
            Log.d("2", "This is button statusbar");
            createNotificationChannel();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,
                    CHANNEL_ID)
                    .setSmallIcon(R.drawable.attention)
                    .setContentTitle("Уведомление в строке состояния")
                    .setContentText("Текст уведомления в строке состояния")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Увеличенный текст уведомления в строке состояния с большим количеством символов, который не вмещается в одну строку"));
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
            notificationManager.notify(notificationId, builder.build());

        }
        if (but == R.id.button_alert_dialog) {
            Log.d("3", "This is button alert dialog");
            FragmentManager manager = getSupportFragmentManager();
            MyDialogFragment myDialogFragment = new MyDialogFragment();
            myDialogFragment.show(manager, "myDialog");
        }
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                    name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
