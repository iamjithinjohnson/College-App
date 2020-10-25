package com.example.ctadmin.mypolytech;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class syllabus extends AppCompatActivity {
    LinearLayout ct,ec,td;
    ImageView back,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
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
                Uri uri = Uri.parse("https://drive.google.com/drive/folders/1r9wrTuZIzkpupX2oTQXJ5FsTobt15h8r");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://drive.google.com/drive/folders/1v_CPPF4fcyWpUQVyn4YLUT0msv9reaX2");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://drive.google.com/drive/folders/1hKuj6AL22rbp6e5uJzOrwv_N9pBT7Uu0");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
