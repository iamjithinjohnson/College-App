package com.example.ctadmin.mypolytech;

/**
 * Created by jithin on 4/22/2020.
 */

public class LibData {
    private String id, bookid, bookname,issuedon,issuedtill,returnedon,fine;

    public LibData(String id, String bookid, String bookname,String issuedon, String issuedtill, String returnedon,String fine) {
        this.id = id;
        this.bookid = bookid;
        this.bookname = bookname;
        this.issuedon = issuedon;
        this.issuedtill = issuedtill;
        this.returnedon = returnedon;
        this.fine = fine;


    }
    public String getId(){
        return id;
    }

    public String getBookid() {
        return bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public String getIssuedon() {
        return issuedon;
    }

    public String getIssuedtill() {
        return issuedtill;
    }

    public String getReturnedon() {
        return returnedon;
    }

    public String getFine() {
        return fine;
    }

}
