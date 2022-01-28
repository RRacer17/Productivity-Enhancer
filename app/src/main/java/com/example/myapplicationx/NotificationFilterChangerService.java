package com.example.myapplicationx;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;
import android.content.Context;

public class NotificationFilterChangerService extends IntentService {
    private static final String TAG = "NotifFilterService";

    public NotificationFilterChangerService() {
        // Used to name the worker thread
        // Important only for debugging
        super(NotificationFilterChangerService.class.getName());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, ".onCreate");
     }
    @Override
    protected void onHandleIntent(Intent in) {
        Log.i(TAG, ".onHandleIntent " + in);
        final Context context = getApplicationContext();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
{
                String mode = in.getStringExtra("mode");
                final int filter;
                if (mode == null) {
                    boolean quiet = in.getBooleanExtra("quiet", true);
                    filter = quiet ? NotificationManager.INTERRUPTION_FILTER_PRIORITY : NotificationManager.INTERRUPTION_FILTER_ALL;
                    notificationManager.setInterruptionFilter(filter);
                    AudioManager mobilemode = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                    int volume = in.getIntExtra("ringer", mobilemode.getStreamMaxVolume(AudioManager.STREAM_RING));
                    Log.i(TAG, ".onHandleIntent volume " + volume);
                    mobilemode.setStreamVolume(AudioManager.STREAM_RING, volume, 0);
                } else {
                    Log.i(TAG, ".onHandleIntent mode " + mode);
                    if (mode.equals("all"))
                        filter = NotificationManager.INTERRUPTION_FILTER_ALL;
                    else if (mode.equals("none"))
                        filter = NotificationManager.INTERRUPTION_FILTER_NONE;
                    else if (mode.equals("priority"))
                        filter = NotificationManager.INTERRUPTION_FILTER_PRIORITY;
                    else if (mode.equals("alarms"))
                        filter = NotificationManager.INTERRUPTION_FILTER_ALARMS;
                    else {
                        Log.w(TAG, ".onHandleIntent unknown mode " + mode);
                        return;
                    }
                }
                Log.i(TAG, ".onHandleIntent setInterruptionFilter " + filter);
                notificationManager.setInterruptionFilter(filter);
            }
        }
    }
}
