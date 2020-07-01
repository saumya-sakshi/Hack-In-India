package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class Webview extends AppCompatActivity {
    WebView webView;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Intent intent=getIntent();
        data=intent.getStringExtra("a");
        webView = findViewById(R.id.webView);
        webView.loadUrl(data);
    }
}
