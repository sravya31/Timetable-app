package com.example.sravyanaguboyina.timetable;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sravya naguboyina on 11-10-2017.
 */

public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context,Intent intent){
        Log.e("we are in the receiver.","Yay!");
        String getstring=intent.getExtras().getString("extra");
        Log.e("whats the key?", getstring);

        Intent service_intent=new Intent(context,RingtonePlayingService.class);

        service_intent.putExtra("extra", getstring);

        context.startService(service_intent);
        Toast.makeText(context, "Alarm Ringing", Toast.LENGTH_LONG).show();
    }

}
