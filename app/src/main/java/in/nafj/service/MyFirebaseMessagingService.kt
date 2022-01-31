package com.kintree.service

import `in`.nafj.R
import `in`.nafj.activity.HomeActivity
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


private const val TAG = "FirebaseMessaging"

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

        Log.i(TAG, "token: $p0")

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        Log.i(TAG, "onMessageReceived: ${p0.data}")
        Log.i(TAG, "onMessageReceived Notification: ${p0.notification}")

        sendNotification(p0)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sendNotification(remoteMessage: RemoteMessage) {
        val notification = remoteMessage.data
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT
        )

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            /* val sound = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + this.packageName + "/" + R.raw.ringtone)
             val audioAttributes = AudioAttributes.Builder()
                 //.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                 .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
                 .build()*/

            val notificationChannel = NotificationChannel(
                "Kintree",
                "Test Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificationChannel.description = "New channel created"
//            notificationChannel.setSound(sound, audioAttributes)

            notificationManager.createNotificationChannel(notificationChannel)
        }

        //custom notification view
        /*val notificationLayout = RemoteViews(this.packageName, R.layout.notification_layout)
        notificationLayout.setTextViewText(R.id.content_title, notification!!.title)
        notificationLayout.setTextViewText(R.id.content_body, notification.body)*/

        val notificationBuilder: Notification.Builder = Notification.Builder(this, "Kintree")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(notification["title"])
            .setContentText(notification["body"])
            .setAutoCancel(true)
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)
//            .setCustomBigContentView(notificationLayout)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    this.resources,
                    R.drawable.ic_launcher_foreground
                )
            )

        val random = Math.random().toInt()
        notificationManager.notify(random, notificationBuilder.build())
//        playSound()

    }

    private fun playSound() {
        /*val mediaPlayer = MediaPlayer.create(this, R.raw.ringtone)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.stop()
            mediaPlayer.release()
        }*/

    }
}