package com.example.lawyerfinderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView tvForgotPassword, tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI components
        btnLogin = findViewById(R.id.LoginButton);
        tvForgotPassword = findViewById(R.id.textViewForgotPassword);
        tvSignUp = findViewById(R.id.textView7);

        btnLogin.setOnClickListener(view -> loginUser());

        tvForgotPassword.setOnClickListener(view ->
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class)));

        tvSignUp.setOnClickListener(view ->
                startActivity(new Intent(LoginActivity.this, SignupActivity.class)));
    }

    private void loginUser() {
        // Auto-login directly to HomeActivity
        navigateToHome();
    }

    private void navigateToHome() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
