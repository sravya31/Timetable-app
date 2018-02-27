package com.example.sravyanaguboyina.timetable;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.delaroystudios.cardview.*;

public class Monday extends AppCompatActivity {

    //DatabaseHelper mydb;

    monday_database mydb;
    private static Button button_mon;
    Button btnviewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb = new monday_database(this);
        setContentView(R.layout.activity_monday);
        OnClickButtonListener();
        btnviewAll = (Button)findViewById(R.id.view1);
        viewAllMethod();
    }
    public void OnClickButtonListener(){
        button_mon = (Button)findViewById(R.id.monadd);
        button_mon.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.mon_addclass");
                        startActivity(intent);
                    }
                }
        );
    }
    public void viewAllMethod(){
        btnviewAll.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Cursor res = mydb.getAllData();
                        if(res.getCount() == 0){
                            showMessage("Error","No Data Found ");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("CLASS :"+res.getString(0)+"\n");
                            buffer.append("SUBJECT :"+res.getString(1)+"\n");
                            buffer.append("PROFESSOR :"+res.getString(2)+"\n");
                            buffer.append("START :"+res.getString(3)+"\t"+"End :"+res.getString(4)+"\n");
                            buffer.append("ROOM NO :"+res.getString(5)+"\n");
                        }
                        //show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);   //create alert dailog
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
