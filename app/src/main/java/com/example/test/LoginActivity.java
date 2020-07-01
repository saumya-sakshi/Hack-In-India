package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText editEmail,editPassword;
    Button btnLogin;
    TextView textForgotPassword, textSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Initialization();
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.toString();
                String password = editPassword.toString();
                if (TextUtils.isEmpty(email)){
                    editEmail.setError("Email must not be empty");
                } else if (TextUtils.isEmpty(password)){
                    editPassword.setError("Password should not be empty");
                } else {

                }
            }
        });
    }

    private void Initialization() {
        editEmail = findViewById(R.id.inputEmail);
        editPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        textForgotPassword = findViewById(R.id.forgetPassword);
        textSignup = findViewById(R.id.signUp);
    }
}