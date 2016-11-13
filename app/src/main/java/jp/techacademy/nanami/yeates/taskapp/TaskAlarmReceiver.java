package jp.techacademy.nanami.yeates.taskapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;
import android.util.Log;


public class TaskAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // 通知の設定を行う
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.small_icon);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.large_icon));
        builder.setWhen(System.currentTimeMillis());
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setAutoCancel(true);

        // タスクの情報を設定する
        Task task = (Task) intent.getSerializableExtra(MainActivity.EXTRA_TASK);
        try {
            builder.setTicker(task.getTitle()); // 5.0以降は表示されない
            builder.setContentTitle(task.getTitle());
            builder.setContentText(task.getContents());
        } catch (NullPointerException e) {
            Log.d("java", "発生した");
        } catch (RuntimeException e) {
            Log.d("javatest", "例外発生");
        } catch (Exception e) {
            Log.d("javatest", "例外発生");
        }

        // 通知をタップしたらアプリを起動するようにする
        Intent startAppIntent = new Intent(context, MainActivity.class);
        startAppIntent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, startAppIntent, 0);
        builder.setContentIntent(pendingIntent);

        // 通知を表示する
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        try {
            notificationManager.notify(task.getId(), builder.build());
        } catch (NullPointerException e) {
            Log.d("java", "発生した");
        } catch (RuntimeException e) {
            Log.d("javatest", "例外発生");
        } catch (Exception e) {
            Log.d("javatest", "例外発生");
        }
    }
}
