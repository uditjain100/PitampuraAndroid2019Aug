package com.codingblocks.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nm.createNotificationChannel(
                NotificationChannel(
                    "first",
                    "demo",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )
        }

        val simpleNotification = NotificationCompat.Builder(this, "first")
            .setContentTitle("Simple Notification")
            .setContentText("Sample Description for the notification")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Hello world this is the bigger txt,Hello world this is the bigger txt,Hello world this is the bigger txt,Hello world this is the bigger txt,Hello world this is the bigger txt,Hello world this is the bigger txt")
            )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        nm.notify(System.currentTimeMillis().toInt(), simpleNotification)


    }
}