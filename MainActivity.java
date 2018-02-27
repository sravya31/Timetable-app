package com.example.sravyanaguboyina.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button button_sm;
    private static Button button_m;
    private static Button button_r;
    private static Button button_re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        button_sm = (Button)findViewById(R.id.viewtt);
        button_sm.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.ViewTimetable");
                        startActivity(intent);
                    }
                }
        );
        button_m = (Button)findViewById(R.id.testsech);
        button_m.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.testscheduled");
                        startActivity(intent);
                    }
                }
        );

        button_r = (Button)findViewById(R.id.sub);
        button_r.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.resources");
                        startActivity(intent);
                    }
                }
        );

        button_re = (Button)findViewById(R.id.reso);
        button_re.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.setalarm");
                        startActivity(intent);
                    }
                }
        );

    }

}
