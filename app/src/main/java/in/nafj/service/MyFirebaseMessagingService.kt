package `in`.nafj.service

import `in`.nafj.R
import `in`.nafj.activity.LockScreenNotificationActivity
import `in`.nafj.activity.NotificationsDataModel
import `in`.nafj.database.DatabaseHelper
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*


private const val TAG = "FirebaseMessaging"

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

        Log.i(TAG, "token: $p0")

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        
        sendNotification(p0)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sendNotification(remoteMessage: RemoteMessage) {

        try {
            val data = remoteMessage.data
            val notificationTitle = data["title"]
            val notificationBody = data["body"]
            val sound = data["sound"]
            val notificationProductId = data["productId"]
            val notificationProductCategory = data["categoryName"]
            val notificationProductImage = data["productImage"]

            val db = DatabaseHelper(this)
            try {
                db.insertIntoNotification(NotificationsDataModel(
                    notificationTitle.toString(),
                    notificationBody.toString(),
                    notificationProductId!!.toInt(),
                    notificationProductCategory.toString(),
                    "",
                    notificationProductImage.toString()
                ))
            } catch (e: Exception) {
            }

            Log.i(TAG, "sendNotification: title: $notificationTitle")
            Log.i(TAG, "sendNotification: body: $notificationBody")
            Log.i(TAG, "sendNotification: sound: $sound")
            val random: Int = Random().nextInt(9999 - 1000) + 1000
            val fullScreenIntent = Intent(this, LockScreenNotificationActivity::class.java)
            // Create the TaskStackBuilder
            val vibrate = longArrayOf(0, 100, 200, 300, 400, 500, 500)
            val fullScreenPendingIntent =
                PendingIntent.getActivity(this, random, fullScreenIntent, PendingIntent.FLAG_IMMUTABLE)
            val alarmSound = Uri.parse("android.resource://" + packageName + "/" + R.raw.ringtone)
            val notificationBuilder: NotificationCompat.Builder =
                NotificationCompat.Builder(this, "Nafj_All")
                    .setSmallIcon(R.drawable.app_logo)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationBody)
                    .setAutoCancel(true)
                    .setOnlyAlertOnce(true)
                    .setSound(alarmSound)
                    .setVibrate(vibrate)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                    .setFullScreenIntent(fullScreenPendingIntent, true)
//            .setCustomBigContentView(notificationLayout)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.mipmap.app_logo_icon_round
                        )
                    )

            if (notificationBody!!.length > 25) {
                notificationBuilder.setStyle(NotificationCompat.BigTextStyle().bigText(notificationBody))
            }

            //custom notification view
            /*val notificationLayout = RemoteViews(this.packageName, R.layout.notification_layout)
            notificationLayout.setTextViewText(R.id.content_title, notification!!.title)
            notificationLayout.setTextViewText(R.id.content_body, notification.body)*/

            val powerManager: PowerManager = this.getSystemService(POWER_SERVICE) as PowerManager
            if (!powerManager.isInteractive) { // if screen is not already on, turn it on (get wake_lock for 10 seconds)
                val wakeLock = powerManager.newWakeLock(
                    PowerManager.PARTIAL_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP,
                    "nafj:notification_received"
                )
                wakeLock.acquire(10000)
            }

            with(NotificationManagerCompat.from(this)) {
                notify(random, notificationBuilder.build())
            }
//        playSound()

        } catch (exception: Exception) {
            Log.i(TAG, "sendNotification: $exception")
        }


    }
}