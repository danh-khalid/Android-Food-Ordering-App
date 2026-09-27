package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText fullName, username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullName = findViewById(R.id.fullName);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Button createAccount = findViewById(R.id.createAccount);
        Button backToLogin = findViewById(R.id.backToLogin);

        createAccount.setOnClickListener(v -> {
            String fullNameStr = fullName.getText().toString().trim();
            String usernameStr = username.getText().toString().trim();
            String emailStr = email.getText().toString().trim();
            String passwordStr = password.getText().toString().trim();

            if (!fullNameStr.isEmpty() && !usernameStr.isEmpty() && !emailStr.isEmpty() && !passwordStr.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Account created!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        backToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
