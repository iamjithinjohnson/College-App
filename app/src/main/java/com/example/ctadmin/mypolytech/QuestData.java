package com.example.ctadmin.mypolytech;


public class QuestData {
    private String id, subject, code, paper, url,semester;



    public QuestData(String id, String subject, String code, String paper, String url, String semester) {
        this.id = id;
        this.subject = subject;
        this.code = code;
        this.paper = paper;
        this.url = url;
        this.semester = semester;


    }
    public String getId(){
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getCode() {
        return code;
    }

    public String getPaper() {
        return paper;
    }

    public String getUrl() {
        return url;
    }

    public String getSemester() {
        return semester;
    }


}
