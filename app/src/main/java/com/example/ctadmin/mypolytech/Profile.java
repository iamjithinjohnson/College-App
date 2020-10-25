package com.example.ctadmin.mypolytech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView register,name,branch,semester,address,dob,gender;
    ImageView back,logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        register = (TextView) findViewById(R.id.register);
        name = (TextView) findViewById(R.id.name);
        branch = (TextView) findViewById(R.id.branch);
        semester = (TextView) findViewById(R.id.semester);
        address = (TextView) findViewById(R.id.address);
        dob = (TextView) findViewById(R.id.dob);
        gender = (TextView) findViewById(R.id.gender);

        register.setText(SharedPrefManager.getInstance(this).getRegisterNumber());
        name.setText(SharedPrefManager.getInstance(this).getName());
        branch.setText(SharedPrefManager.getInstance(this).getBranch());
        semester.setText(SharedPrefManager.getInstance(this).getSemester());
        address.setText(SharedPrefManager.getInstance(this).getAddress());
        dob.setText(SharedPrefManager.getInstance(this).getDate());
        gender.setText(SharedPrefManager.getInstance(this).getGender());

        back = (ImageView)  findViewById(R.id.back);
        logout = (ImageView)  findViewById(R.id.logout);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, login.class));
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(getApplicationContext()).logout();
                finish();
                startActivity(new Intent(getApplicationContext(), login.class));
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





    }
}
