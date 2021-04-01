package th.ac.kku.cis.lab.notificationapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.text.format.DateUtils
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationBuilder: Notification.Builder

    private val channelID = "th.ac.kku.cis.lab.notificationapplication"
    private val description = "Simple Notification"

    private val NOTIFICATION_TITLE = "Notification Sample App"
    private val CONTENT_TEXT = "Expand me to see a detailed message!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        button.setOnClickListener {
            callExpandNotification()

        }

        button2.setOnClickListener{
            callSimpleNotification()
        }
    }
    /*
    create simple notification
     */
    private fun callSimpleNotification() {
        val intents = arrayOfNulls<Intent>(2)
        intents[0] = Intent.makeMainActivity(
            ComponentName(
                this,
                MainActivity::class.java
            ))
        intents[1] = Intent(this, MainActivity::class.java)

        var pendingIntent = PendingIntent.getActivities(this, 0, intents, PendingIntent.FLAG_UPDATE_CURRENT)

        notificationChannel = NotificationChannel(channelID, description, NotificationManager.IMPORTANCE_HIGH)
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.GREEN
        notificationChannel.enableVibration(true)
        notificationManager.createNotificationChannel(notificationChannel)

        notificationBuilder = Notification.Builder(this,channelID)
            .setSmallIcon(R.drawable.ic_launcher_round)
            .setContentTitle("CIS Lab")
            .setContentText("Test notification")
            //optional
            .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_round))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        notificationManager.notify(1234, notificationBuilder.build())
    }

    /*
    create collapse and expand Notification
     */
    private fun callExpandNotification(){
        //set expanded view
        var expandedView = RemoteViews(packageName,R.layout.view_expanded_notification)
        expandedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));
        expandedView.setTextViewText(R.id.notification_message, mEditText.getText());
        //set collapsed view
        var collapsedView = RemoteViews(packageName, R.layout.view_collapsed_notification)
        collapsedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));

        //set intents
        val intents = arrayOfNulls<Intent>(2)
        intents[0] = Intent.makeMainActivity(
            ComponentName(
                this,
                MainActivity::class.java
            ))
        intents[1] = Intent(this, MainActivity::class.java)
        var pendingIntent = PendingIntent.getActivities(this, 0, intents, PendingIntent.FLAG_UPDATE_CURRENT)

        var builder = Notification.Builder(this, channelID)
            .setSmallIcon(R.drawable.ic_launcher_round)
            .setContentTitle(NOTIFICATION_TITLE)
            .setContentText(CONTENT_TEXT)
            // notification will be dismissed when tapped
            .setAutoCancel(true)
            // tapping notification will open MainActivity
            .setContentIntent(pendingIntent)
            // setting the custom collapsed and expanded views
            .setCustomContentView(collapsedView)
            .setCustomBigContentView(expandedView)

        notificationManager.notify(1234, builder.build())
    }
}
