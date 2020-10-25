package com.example.ctadmin.mypolytech;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class home extends AppCompatActivity {
    LinearLayout btlink,btfeedback,btabout,q,s,l,i,st,profile,notification,library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        q=(LinearLayout) findViewById(R.id.bt1);
        s=(LinearLayout) findViewById(R.id.bt3);
        l=(LinearLayout) findViewById(R.id.bt5);
        st=(LinearLayout) findViewById(R.id.bt6);
        profile=(LinearLayout) findViewById(R.id.profile);
        btabout=(LinearLayout) findViewById(R.id.bt7);
        btfeedback=(LinearLayout) findViewById(R.id.bt8);
        notification=(LinearLayout) findViewById(R.id.notification);
        library=(LinearLayout) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Library.class);
                startActivity(i);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Notifications.class);
                startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Profile.class);
                startActivity(i);
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Staff_select.class);
                startActivity(i);
            }
        });
        btabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),about.class);
                startActivity(i);
            }
        });
        //btfeedback.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
            //    Intent i=new Intent(getApplicationContext(),feedback.class);
           //     startActivity(i);
           // }
       // });
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),question_papper.class);
                startActivity(i);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),syllabus.class);
                startActivity(i);
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),link.class);
                startActivity(i);
            }
        });
    }
    private void confirmDialog(){

        final AlertDialog alert = new AlertDialog.Builder(home.this).create();

        alert.setMessage("Do you really want to exit application?");
        alert.setCancelable(false);
        alert.setCanceledOnTouchOutside(false);

        alert.setButton(DialogInterface.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alert.dismiss();
                        finish();
                    }
                });
        alert.setButton(DialogInterface.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        alert.dismiss();
                    }
                });
        alert.show();
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        confirmDialog();
    }
}
