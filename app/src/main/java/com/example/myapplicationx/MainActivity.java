package com.example.myapplicationx;

import android.app.NotificationManager;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.os.Build;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "MainActivity.onCreate");

        Button movex = (Button) findViewById(R.id.movex);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            final NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
            if (!notificationManager.isNotificationPolicyAccessGranted()) {
                Intent intent = new Intent(android.provider.Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }

        if (false) if (false) {
            final Intent i = new Intent(this, NotificationFilterChangerService.class);
            i.putExtra("foo", "bar");
            startService(i);
        } else {
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("com.example.myapplication.NotificationFilterChangerService");
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            sendBroadcast(broadcastIntent);

        }
        movex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                move();
            }
        });
}

    public void move() {
        Toast.makeText(getApplicationContext(), "top", Toast.LENGTH_SHORT).show();
        Intent t = new Intent(this, TimerActivity.class);
        startActivity(t);
    }
}