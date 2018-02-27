package com.example.sravyanaguboyina.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import com.delaroystudios.cardview.R;

public class testscheduled extends AppCompatActivity {
    private static Button button_t;
    private static Button button_v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testscheduled);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        button_t = (Button)findViewById(R.id.addtest);
        button_t.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.Newtest");
                        startActivity(intent);
                    }
                }
        );

        button_v = (Button)findViewById(R.id.viewall);
        button_v.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.viewtest");
                        startActivity(intent);
                    }
                }
        );
    }
}
