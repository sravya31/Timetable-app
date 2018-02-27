package com.example.sravyanaguboyina.timetable;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.AlarmManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.os.Handler;
import java.util.Calendar;

//import com.delaroystudios.cardview.R;

public class setalarm extends AppCompatActivity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setalarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.context=this;
        alarm_manager =(AlarmManager) getSystemService(ALARM_SERVICE);
        alarm_timepicker =(TimePicker) findViewById(R.id.timePicker);
        update_text=(TextView)findViewById(R.id.update_text);
        final Calendar calendar = Calendar.getInstance();


        Button alarm_on =(Button) findViewById(R.id.alarm_on);



        alarm_on.setOnClickListener(
                new View.OnClickListener(){
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(View v){
                        final Intent my_intent = new Intent(setalarm.this,Alarm_Receiver.class);
                        calendar.add(Calendar.SECOND, 3);



                        int hour = 0;
                        int minute = 0;

                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                            hour = alarm_timepicker.getHour();
                            minute = alarm_timepicker.getMinute();
                        } else {
                            hour = alarm_timepicker.getCurrentHour();
                            minute = alarm_timepicker.getCurrentMinute();
                        }

                        Log.e("MyActivity", "In the receiver with " + hour + " and " + minute);


                        calendar.set(Calendar.HOUR_OF_DAY,alarm_timepicker.getHour());
                        calendar.set(Calendar.MINUTE,alarm_timepicker.getMinute());


                        String hour_string = String.valueOf(hour);
                        String minute_string =String.valueOf(minute);
                        if(hour > 12){
                            hour_string = String.valueOf(hour-12);
                        }

                        if(minute < 10){
                            minute_string = "0"+String.valueOf(minute);
                        }
                        set_alarm_test("Alarm set to: "+hour_string+":"+minute_string);

                        my_intent.putExtra("extra", "alarm on");

                      pending_intent=PendingIntent.getBroadcast(setalarm.this,0,my_intent,PendingIntent.FLAG_UPDATE_CURRENT);
                       alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pending_intent);

                    }
                }
        );


        Button alarm_off = (Button) findViewById(R.id.alarm_off);

        alarm_off.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        final Intent my_intent = new Intent(setalarm.this,Alarm_Receiver.class);
                        set_alarm_test("Remainder off!....");
                        alarm_manager.cancel(pending_intent);

                        my_intent.putExtra("extra", "alarm off");
                        sendBroadcast(my_intent);
                    }
                }
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void set_alarm_test(String output) {
      update_text.setText(output);
    }

}
