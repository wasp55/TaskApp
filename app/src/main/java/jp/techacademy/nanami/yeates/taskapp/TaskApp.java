package jp.techacademy.nanami.yeates.taskapp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Jason Yeates on 31/10/2016.
 */

public class TaskApp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
    }
}
