package com.example.sravyanaguboyina.timetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.version;
import static com.example.sravyanaguboyina.timetable.R.id.endtxt1;
import static com.example.sravyanaguboyina.timetable.R.id.proftxt1;
import static com.example.sravyanaguboyina.timetable.R.id.roomtxt1;
import static com.example.sravyanaguboyina.timetable.R.id.starttxt1;
import static com.example.sravyanaguboyina.timetable.R.id.subtxt1;

/**
 * Created by sravya naguboyina on 05-10-2017.
 */

public class testdatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "test.db";
    public static final String TABLE_NAME = "test_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "SUBJECT";
    public static final String COL_3 = "DATE";
    public static final String COL_4 = "START_TIME";
    public static final String COL_5 = "END_TIME";
    public static final String COL_6 = "ROOM_NO";
    public testdatabase(Context context) {
        super(context,DATABASE_NAME, null, 1);
        //SQLiteDatabase db=this.getWritableDatabase(); //see the database created
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,SUBJECT TEXT,DATE TEXT,START_TIME TIME,END_TIME TIME,ROOM_NO TEXT)");
        Log.d("HI","dd");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String subject,String date,String start,String end,String room){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,date);
        contentValues.put(COL_4,start);
        contentValues.put(COL_5,end);
        contentValues.put(COL_6,room);
        //to insert data
        long result = db.insert(TABLE_NAME,null,contentValues); //if data is creted it returns -1
        if(result== -1){
            return false;
        }
        else
            return true;

    }

    public String showData(int id) {
        StringBuffer buffer = new StringBuffer();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[]{COL_1, COL_2, COL_3, COL_4, COL_5, COL_6};
        Cursor cursor = db.query(TABLE_NAME, columns, COL_1 + "=" + id, null, null, null, null);
        String subj, prof, st, en, room;
        if (cursor.moveToFirst()) {
            do {
                buffer.append(cursor.getString(cursor.getColumnIndex(this.COL_2)));
                buffer.append(" ");
                buffer.append(cursor.getString(cursor.getColumnIndex(this.COL_3)));
                buffer.append(" ");
                buffer.append(cursor.getString(cursor.getColumnIndex(this.COL_4)));
                buffer.append(" ");
                buffer.append(cursor.getString(cursor.getColumnIndex(this.COL_5)));
                buffer.append(" ");
                buffer.append(cursor.getString(cursor.getColumnIndex(this.COL_6)));
                buffer.append(" ");

            } while (cursor.moveToNext());

        }
        return buffer.toString();
    }
    //cursor provides random read and write
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String subject,String date,String start,String end,String room){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,subject);
        contentValues.put(COL_3,date);
        contentValues.put(COL_4,start);
        contentValues.put(COL_5,end);
        contentValues.put(COL_6,room);
        db.update(TABLE_NAME,contentValues, "ID = ?",new String[] {id});
        return true;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
    //public
}
