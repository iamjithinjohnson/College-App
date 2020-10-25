package com.example.ctadmin.mypolytech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Question_Semester extends AppCompatActivity {
    String branch;
    ImageView back,logout;
    LinearLayout bt1,bt2,bt3,bt4,bt5,bt6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__semester);

        bt1=(LinearLayout) findViewById(R.id.bt1);
        bt2=(LinearLayout) findViewById(R.id.bt2);
        bt3=(LinearLayout) findViewById(R.id.bt3);
        bt4=(LinearLayout) findViewById(R.id.bt4);
        bt5=(LinearLayout) findViewById(R.id.bt5);
        bt6=(LinearLayout) findViewById(R.id.bt6);




        back = (ImageView) findViewById(R.id.back) ;
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

        Intent i= getIntent();
        Bundle b = i.getExtras();

        if(b!=null)
        {
            branch =(String) b.get("branch");
        }

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "1";
                Intent i=new Intent(getApplicationContext(),Questions.class);
                i.putExtra("semester",type);
                i.putExtra("branch", branch);
                startActivity(i);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "2";
                Intent i=new Intent(getApplicationContext(),Questions.class);
                i.putExtra("semester",type);
                i.putExtra("branch", branch);
                startActivity(i);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "3";
                Intent i=new Intent(getApplicationContext(),Questions.class);
                i.putExtra("semester",type);
                i.putExtra("branch", branch);
                startActivity(i);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "4";
                Intent i=new Intent(getApplicationContext(),Questions.class);
                i.putExtra("semester",type);
                i.putExtra("branch", branch);
                startActivity(i);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "5";
                Intent i=new Intent(getApplicationContext(),Questions.class);
                i.putExtra("semester",type);
                i.putExtra("branch", branch);
                startActivity(i);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "6";
                Intent i=new Intent(getApplicationContext(),Questions.class);
                i.putExtra("semester",type);
                i.putExtra("branch", branch);
                startActivity(i);
            }
        });

    }
}
