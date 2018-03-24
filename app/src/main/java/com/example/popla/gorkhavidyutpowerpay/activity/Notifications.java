package com.example.popla.gorkhavidyutpowerpay.activity;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import com.example.popla.gorkhavidyutpowerpay.R;



public class Notifications extends AppCompatActivity {

    NotificationCompat.Builder notifaications;
    private static final int uniqueID = 45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        notifaications = new NotificationCompat.Builder(this);
        notifaications.setAutoCancel(true);
    }


    public void button(View v)
    {

        Intent intent = new Intent(this, Notifications.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notifaications.setContentIntent(pendingIntent);

        notifaications.setSmallIcon(R.drawable.leaf);
        notifaications.setTicker("this is ticker");
        notifaications.setVibrate(new long[] {1000, 1000, 1000, 1000});
        notifaications.setWhen(0);
        notifaications.setContentTitle("Here is title");
        notifaications.setContentText("Body of notification");
         notifaications.addAction(R.drawable.leaf,"Action1",pendingIntent);
        notifaications.addAction(R.drawable.leaf,"Action2",pendingIntent);

        NotificationManager nb=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nb.notify(uniqueID, notifaications.build());

        }

    }

