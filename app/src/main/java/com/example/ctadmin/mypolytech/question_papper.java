package com.example.ctadmin.mypolytech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class  question_papper extends AppCompatActivity {
    LinearLayout ct,ec,td;
    ImageView back,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_papper);
        ct=(LinearLayout) findViewById(R.id.bt1);
        ec=(LinearLayout) findViewById(R.id.bt2);
        td=(LinearLayout) findViewById(R.id.bt3);

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

        ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "CT";
                Intent i=new Intent(getApplicationContext(),Question_Semester.class);
                i.putExtra("branch",type);
                startActivity(i);
            }
        });
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "EC";
                Intent i=new Intent(getApplicationContext(),Question_Semester.class);
                i.putExtra("branch",type);
                startActivity(i);

            }
        });
        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "TD";
                Intent i=new Intent(getApplicationContext(),Question_Semester.class);
                i.putExtra("branch",type);
                startActivity(i);
            }
        });
    }
}
