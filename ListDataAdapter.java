package com.example.sravyanaguboyina.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sravya naguboyina on 08-10-2017.
 */

public class ListDataAdapter extends ArrayAdapter {
    List list =new ArrayList();
    public ListDataAdapter(Context context,int resource){
        super(context,resource);
    }
    static class LayoutHandler{
        TextView SUBJECT,DATE,START,END,ROOM;
    }
    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }
    @Override
    public int getCount(){
        return list.size();
    }
    @Override
    public Object getItem(int position){
        return list.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null){
            LayoutInflater layoutInflater =(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list1,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.SUBJECT=(TextView) row.findViewById(R.id.subl);
            layoutHandler.DATE=(TextView) row.findViewById(R.id.datel);
            layoutHandler.START=(TextView) row.findViewById(R.id.startl);
            layoutHandler.END=(TextView) row.findViewById(R.id.endl);
            layoutHandler.ROOM=(TextView) row.findViewById(R.id.rooml);
            row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler) row.getTag();
        }
            dataprovider dp1 = (dataprovider) this.getItem(position);
            layoutHandler.SUBJECT.setText(dp1.getSubj());
            layoutHandler.DATE.setText(dp1.getDate());
            layoutHandler.START.setText(dp1.getStart());
            layoutHandler.END.setText(dp1.getEnd());
            layoutHandler.ROOM.setText(dp1.getRoom());

        return row;
        }
    }



