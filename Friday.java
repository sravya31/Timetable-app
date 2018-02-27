package com.example.sravyanaguboyina.timetable;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import com.delaroystudios.cardview.R;

public class Friday extends AppCompatActivity {

    friday_database mydb;
    private static Button button_fri;
    Button btnviewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb = new friday_database(this);
        setContentView(R.layout.activity_friday);
        OnClickButtonListener();
        btnviewAll = (Button)findViewById(R.id.view5);
        viewAllMethod();
    }
    public void OnClickButtonListener(){
        button_fri = (Button)findViewById(R.id.friadd);
        button_fri.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.fri_addclass");
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
