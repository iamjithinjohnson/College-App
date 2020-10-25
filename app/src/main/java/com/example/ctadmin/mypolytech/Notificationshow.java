package com.example.ctadmin.mypolytech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Notificationshow extends AppCompatActivity {
    String topic ,message,date ;
    TextView topi,messag,dat;
    ImageView back,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationshow);

        topi = (TextView) findViewById(R.id.topic);
        messag = (TextView) findViewById(R.id.message);
        messag.setMovementMethod(LinkMovementMethod.getInstance());
        //dat = (TextView) findViewById(R.id.date);
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



        Intent i= getIntent();
        Bundle b = i.getExtras();

        if(b!=null)
        {
            topic =(String) b.get("topic");
            message =(String) b.get("message");
            date =(String) b.get("date");
        }

        topi.setText(topic);
        messag.setText(message);
    }
}
