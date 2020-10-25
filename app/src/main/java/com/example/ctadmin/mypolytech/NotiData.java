package com.example.ctadmin.mypolytech;

/**
 * Created by jithin on 4/22/2020.
 */

public class NotiData {
    private String id, topic, message,date;

    public NotiData(String id, String topic, String message,String date) {
        this.id = id;
        this.topic = topic;
        this.message = message;
        this.date = date;


    }
    public String getId(){
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

}
