package com.example.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText emailText;
    EditText passwordText;
    Button loginButton;
    TextView signupLink;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailText= findViewById(R.id.input_email);
        passwordText= findViewById(R.id.input_password);
        loginButton= findViewById(R.id.btn_login);
        signupLink= findViewById(R.id.link_signup);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("WSO INTELLIGENCE");
        toolbar.setTitleTextColor(Color.WHITE);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validate()){
                    Toast.makeText(getBaseContext(), "Log in failed", Toast.LENGTH_LONG).show();
                    loginButton.setEnabled(true);
                }

                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                if (email.equals("administrator@euc.com") && password.equals("VMware1!")) {
                    Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(MainIntent);
                    Toast.makeText(LoginActivity.this, "You logged in successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Email or Password is incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
            valid = true;
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
            valid = true;
        }

        return valid;
    }
}
