package com.example.notificationsfcm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnNotify;
    EditText edttxt1, edttxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = findViewById(R.id.btnNotify);
        edttxt1 = findViewById(R.id.edttxt1);
        edttxt2 = findViewById(R.id.edttxt2);

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

                    NotificationChannel channel = new NotificationChannel("YOUR_CHANNEL_ID",
                            "YOUR_CHANNEL_NAME",
                            NotificationManager.IMPORTANCE_DEFAULT);

                    notificationManager.createNotificationChannel(channel);
                }

                NotificationCompat.Builder builder = new  NotificationCompat.Builder(MainActivity.this, "YOUR_CHANNEL_ID")
                        .setSmallIcon(R.drawable.icon_notification)
                        .setContentTitle(edttxt1.getText().toString())
                        .setContentText(edttxt2.getText().toString())
                        .setAutoCancel(true);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                builder.setContentIntent(pendingIntent);
                notificationManager.notify(0, builder.build());
            }
        });
        
        gullu();
    }

    private void gullu() {
        Toast.makeText(this, "Viku", Toast.LENGTH_SHORT).show();
    }
}
