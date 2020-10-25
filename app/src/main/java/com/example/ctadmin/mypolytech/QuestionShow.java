package com.example.ctadmin.mypolytech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

public class QuestionShow extends AppCompatActivity {
    private WebView webView ;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_show);

        Intent i= getIntent();
        Bundle b = i.getExtras();

        if(b!=null)
        {
            url =(String) b.get("url");

        }
        Log.d("url : ",url);
        WebView webView = (WebView) findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://drive.google.com/drive/folders/1vG-h8Q5SIsplh7pBtmZLBJonQ10c7CGp");



    }



}
