package com.example.sravyanaguboyina.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.delaroystudios.cardview.R;

public class fri_addclass extends AppCompatActivity {

    friday_database mydb;
    EditText editsub, editprof, edits, edite, editr;
    Button btnadddata;
    Button btnviewUpdate;
    EditText editTextId;
    Button btndelete;
    Button btnshow;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fri_addclass);
        mydb = new friday_database(this);
        editsub = (EditText) findViewById(R.id.subtxt5);
        editprof = (EditText) findViewById(R.id.proftxt5);
        edits = (EditText) findViewById(R.id.starttxt5);
        edite = (EditText) findViewById(R.id.endtxt5);
        editr = (EditText) findViewById(R.id.roomtxt5);
        btnadddata = (Button) findViewById(R.id.add5);
        btnviewUpdate = (Button)findViewById(R.id.update5);
        editTextId=(EditText) findViewById(R.id.uptxt5);
        btndelete =(Button) findViewById(R.id.delete5);
        btnshow =(Button) findViewById(R.id.details5);
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
                            Toast.makeText(fri_addclass.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(fri_addclass.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(fri_addclass.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(fri_addclass.this, "Data Not Updated", Toast.LENGTH_SHORT).show();


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
                            Toast.makeText(fri_addclass.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(fri_addclass.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

                    }

                }
        );
    }
}
