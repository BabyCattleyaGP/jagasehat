package com.example.baby.jagasehat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class Notif extends BroadcastReceiver {

    int reqCode = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context) {

        // Set which activity to show when the notification is tapped
        Intent intent = new Intent(context, FirstRun.class);
        PendingIntent pi = PendingIntent.getActivity(context, reqCode, intent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Baca Lagi Yuk")
                .setContentText("Anda belum menyelesaikan JagaSehat, Ayo kembali!")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Anda belum menyelesaikan JagaSehat, Ayo kembali!"));

        mBuilder.setContentIntent(pi);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(reqCode, mBuilder.build());
    }
}
