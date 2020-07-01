package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class Scanner extends AppCompatActivity {
CodeScanner codeScanner;
CodeScannerView scannerView;
TextView resultdata;
String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        scannerView=findViewById(R.id.scannerView);
        resultdata=findViewById(R.id.resultsOfQr);
        codeScanner = new CodeScanner(this,scannerView);
        resultdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Webview.class);
                intent.putExtra("a",s);
                startActivity(intent);
            }
        });

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        resultdata.setText(result.getText());
                        s=resultdata.getText().toString();
                    }
                });
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }
}
