package com.example.sravyanaguboyina.timetable;

/**
 * Created by sravya naguboyina on 08-10-2017.
 */

public class dataprovider {
    private String subj,date,start,end,room;
    public String getSubj(){
        return subj;
    }
    public void setSubj(String subj){
        this.subj=subj;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getStart(){
        return start;
    }
    public void setStart(String start){
        this.start=start;
    }
    public String getEnd(){
        return end;
    }
    public void setEnd(String end){
        this.end=end;
    }
    public String getRoom(){
        return room;
    }
    public void setRoom(String room){
        this.room=room;
    }
    public dataprovider(String subj,String date,String start,String end,String room){
        this.subj=subj;
        this.date=date;
        this.start=start;
        this.end=end;
        this.room=room;

    }


}
