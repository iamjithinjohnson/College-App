package com.example.ctadmin.mypolytech;


import java.sql.Blob;

class StaffData {

    private String id, name, dept,charge,mob,image;


    public StaffData(String id, String name, String dept,String charge, String mob,String image) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.charge = charge;
        this.mob = mob;
        this.image = image;

    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getCharge() {
        return charge;
    }

    public String getMob() {
        return mob;
    }
    public String getImage() {
        return image;
    }
}
