package com.example.sravyanaguboyina.timetable;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.security.Provider;

/**
 * Created by sravya naguboyina on 09-10-2017.
 */

public class RingtonePlayingService extends Service {
    MediaPlayer media_song;
    int startId;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.e("we are in the onBind.","Yay!");
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        String state=intent.getExtras().getString("extra");
        Log.e("Ringtone state: extra is ", state);
        assert state !=null;
        switch (state) {
            case "alarm on":
                startId = 1;

                break;
            case "alarm off":
                startId = 0;
                Log.e("Start ID is", state);
                break;
            default:
                startId = 0;
                break;
        }

        media_song=MediaPlayer.create(this,R.raw.dove1);
        media_song.start();


        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){

        Toast.makeText(this,"on Destroy called", Toast.LENGTH_SHORT).show();
    }





}
