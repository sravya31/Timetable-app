package com.example.sravyanaguboyina.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.delaroystudios.cardview.R;

public class tues_addclass extends AppCompatActivity {
    tuesday_database mydb;
    EditText editsub, editprof, edits, edite, editr;
    Button btnadddata;
    Button btnviewUpdate;
    EditText editTextId;
    Button btndelete;
    Button btnshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tues_addclass);
        mydb = new tuesday_database(this);
        editsub = (EditText) findViewById(R.id.subtxt2);
        editprof = (EditText) findViewById(R.id.proftxt2);
        edits = (EditText) findViewById(R.id.starttxt2);
        edite = (EditText) findViewById(R.id.endtxt2);
        editr = (EditText) findViewById(R.id.roomtxt2);
        btnadddata = (Button) findViewById(R.id.add2);
        btnviewUpdate = (Button)findViewById(R.id.update2);
        editTextId=(EditText) findViewById(R.id.uptxt2);
        btndelete =(Button) findViewById(R.id.delete2);
        btnshow = (Button) findViewById(R.id.details2);
        addData();
        UpdateData();
        DeleteData();
        showdetails();
    }

    public void showdetails(){
        btnshow.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        String s;
                        String[] array=new String[5];
                        String p=editTextId.getText().toString();
                        int value=Integer.parseInt(p);
                        s = mydb.showData(value);
                        int i=0;
                        for(String word : s.split(" ")){
                            array[i]=word;
                            i++;
                        }

                        editsub.setText(array[0]);
                        editprof.setText(array[1]);
                        edits.setText(array[2]);
                        edite.setText(array[3]);
                        editr.setText(array[4]);
                    }
                }
        );

    }

    public void DeleteData(){
        btndelete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = mydb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(tues_addclass.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(tues_addclass.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    public void UpdateData(){
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        boolean isupdate = mydb.updateData(editTextId.getText().toString(),editsub.getText().toString(),editprof.getText().toString(),edits.getText().toString(),edite.getText().toString(),editr.getText().toString());
                        if(isupdate==true)
                            Toast.makeText(tues_addclass.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(tues_addclass.this, "Data Not Updated", Toast.LENGTH_SHORT).show();


                    }
                }
        );
    }
    public void addData() {
        btnadddata.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isinserted = mydb.insertData(editsub.getText().toString(),editprof.getText().toString(),edits.getText().toString(),edite.getText().toString(),editr.getText().toString());
                        if(isinserted == true)
                            Toast.makeText(tues_addclass.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(tues_addclass.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

                    }

                }
        );
    }
}
