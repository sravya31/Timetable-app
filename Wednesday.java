package com.example.sravyanaguboyina.timetable;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import com.delaroystudios.cardview.R;

public class Wednesday extends AppCompatActivity {
    private static Button button_wed;
    wednesday_database mydb;
    Button btnviewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb = new wednesday_database(this);
        setContentView(R.layout.activity_wednesday);
        OnClickButtonListener();
        btnviewAll = (Button)findViewById(R.id.view3);
        viewAllMethod();
    }
    public void OnClickButtonListener(){
        button_wed = (Button)findViewById(R.id.wedadd);
        button_wed.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.timetable.wed_addclass");
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
                            buffer.append("PROFFESSOR :"+res.getString(2)+"\n");
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
