package com.example.sravyanaguboyina.timetable;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.sravyanaguboyina.timetable.R.id.subtxt1;
import static com.example.sravyanaguboyina.timetable.R.id.uptxt1;

//import com.delaroystudios.cardview.R;

public class mon_addclass extends AppCompatActivity {

    monday_database mydb;
    EditText editsub, editprof, edits, edite, editr;
    Button btnadddata;
    Button btnviewUpdate;
    EditText editTextId;
    Button btndelete;
    Button btnshow;
    EditText s;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_addclass);
        mydb = new monday_database(this);
        editsub = (EditText) findViewById(R.id.subtxt1);
        editprof = (EditText) findViewById(R.id.proftxt1);
        edits = (EditText) findViewById(R.id.starttxt1);
        edite = (EditText) findViewById(R.id.endtxt1);
        editr = (EditText) findViewById(R.id.roomtxt1);
        btnadddata = (Button) findViewById(R.id.add1);
        btnviewUpdate = (Button)findViewById(R.id.update1);
        editTextId=(EditText) findViewById(uptxt1);
        btndelete =(Button) findViewById(R.id.delete1);
        btnshow = (Button) findViewById(R.id.details1);
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
                            Toast.makeText(mon_addclass.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mon_addclass.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(mon_addclass.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(mon_addclass.this, "Data Not Updated", Toast.LENGTH_SHORT).show();


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
                        Toast.makeText(mon_addclass.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(mon_addclass.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

                    }

                }
        );
    }

}
