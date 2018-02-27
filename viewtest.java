package com.example.sravyanaguboyina.timetable;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

//import com.delaroystudios.cardview.R;

public class viewtest extends AppCompatActivity {
ListView listview;
    SQLiteDatabase db;
    testdatabase mydb;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtest);
        listview=(ListView)findViewById(R.id.list_view);
       listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.list1);
       listview.setAdapter(listDataAdapter);
        mydb=new testdatabase(getApplicationContext());
        db=mydb.getReadableDatabase();
        cursor=mydb.getAllData();
        if(cursor.moveToFirst()){

            do{
                String subj,date,start,end,room;
                subj = cursor.getString(1);
                date=cursor.getString(2);
                start=cursor.getString(3);
                end=cursor.getString(4);
                room=cursor.getString(5);
                dataprovider dp =new dataprovider(subj,date,start,end,room);
                listDataAdapter.add(dp);
            }while(cursor.moveToNext());
        }
    }
}
