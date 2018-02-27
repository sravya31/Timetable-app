package com.example.sravyanaguboyina.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewTimetable extends AppCompatActivity {


    private static Button button_tm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_timetable);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        button_tm = (Button)findViewById(R.id.monday);
        button_tm.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.Monday");
                        startActivity(intent);
                    }
                }
        );

        button_tm = (Button)findViewById(R.id.tuesday);
        button_tm.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.Tuesday");
                        startActivity(intent);
                    }
                }
        );
        button_tm = (Button)findViewById(R.id.wednesday);
        button_tm.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.Wednesday");
                        startActivity(intent);
                    }
                }
        );

        button_tm = (Button)findViewById(R.id.thursday);
        button_tm.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.Thursday");
                        startActivity(intent);
                    }
                }
        );

        button_tm = (Button)findViewById(R.id.friday);
        button_tm.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.Friday");
                        startActivity(intent);
                    }
                }
        );
    }
}
