package com.example.sravyanaguboyina.timetable;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.sravyanaguboyina.timetable.R.id.uptxt1;
import static com.example.sravyanaguboyina.timetable.R.id.uptxtt;

//import com.delaroystudios.cardview.R;

public class Newtest extends AppCompatActivity {
    testdatabase mydb;
    EditText editsub, editdate, edits, edite, editr;
    Button btnadddata;
    Button btnviewUpdate;
    EditText editTextId;
    Button btndelete;
    Button btnshow;
    EditText s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newtest);
        mydb = new testdatabase(this);
        editsub = (EditText) findViewById(R.id.subtxtt);
        editdate = (EditText) findViewById(R.id.datetxt);
        edits = (EditText) findViewById(R.id.starttxtt);
        edite = (EditText) findViewById(R.id.endtxtt);
        editr = (EditText) findViewById(R.id.roomtxtt);
        btnadddata = (Button) findViewById(R.id.addt);
        btnviewUpdate = (Button)findViewById(R.id.updatet);
        editTextId=(EditText) findViewById(uptxtt);
        btndelete =(Button) findViewById(R.id.deletet);
        btnshow = (Button) findViewById(R.id.detailst);
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
                        editdate.setText(array[1]);
                        edits.setText(array[2]);
                        edite.setText(array[3]);
                        editr.setText(array[4]);
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
    public void DeleteData(){
        btndelete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = mydb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Newtest.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Newtest.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    public void UpdateData(){
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        boolean isupdate = mydb.updateData(editTextId.getText().toString(),editsub.getText().toString(),editdate.getText().toString(),edits.getText().toString(),edite.getText().toString(),editr.getText().toString());
                        if(isupdate==true)
                            Toast.makeText(Newtest.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Newtest.this, "Data Not Updated", Toast.LENGTH_SHORT).show();


                    }
                }
        );
    }
    public void addData() {
        btnadddata.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isinserted = mydb.insertData(editsub.getText().toString(),editdate.getText().toString(),edits.getText().toString(),edite.getText().toString(),editr.getText().toString());
                        if(isinserted == true)
                            Toast.makeText(Newtest.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Newtest.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

                    }

                }
        );
    }

}
