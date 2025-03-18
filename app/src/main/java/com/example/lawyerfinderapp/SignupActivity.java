package com.example.lawyerfinderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText edFirstName, edLastName, edEmail, edPassword, edConfirm;
    Button btnSignup;
    TextView tvLogin;
    RadioGroup rgRole;
    RadioButton rbClient, rbLawyer;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edFirstName = findViewById(R.id.editTexFirstName);
        edLastName = findViewById(R.id.editTextLastName);
        edEmail = findViewById(R.id.editTextTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextConfirmPassword);
        btnSignup = findViewById(R.id.SignupButton);
        tvLogin = findViewById(R.id.textViewLog);
        rgRole = findViewById(R.id.radioGroupRole);
        rbClient = findViewById(R.id.radioButtonClient);
        rbLawyer = findViewById(R.id.radioButtonLawyer);

        db = new Database(this);

        btnSignup.setOnClickListener(view -> {
            String firstname = edFirstName.getText().toString().trim();
            String lastname = edLastName.getText().toString().trim();
            String email = edEmail.getText().toString().trim().toLowerCase(); // Store in lowercase
            String password = edPassword.getText().toString().trim();
            String confirm = edConfirm.getText().toString().trim();

            if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter all details", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(getApplicationContext(), "Invalid email format!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirm)) {
                Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isValidPassword(password)) {
                Toast.makeText(getApplicationContext(), "Password must be at least 8 characters, contain a letter, a digit, and a special character.", Toast.LENGTH_LONG).show();
                return;
            }

            int selectedRoleId = rgRole.getCheckedRadioButtonId();
            if (selectedRoleId == -1) {
                Toast.makeText(getApplicationContext(), "Please select a role", Toast.LENGTH_SHORT).show();
                return;
            }

            String role = (selectedRoleId == R.id.radioButtonClient) ? "client" : "lawyer";

            if (db.register(firstname, lastname, email, password, role)) {
                Toast.makeText(getApplicationContext(), "Signup Successful as " + role, Toast.LENGTH_SHORT).show();

                if (role.equals("lawyer")) {
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                } else {
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                }
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Email already registered!", Toast.LENGTH_SHORT).show();
            }
        });

        tvLogin.setOnClickListener(view -> {
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            finish();
        });
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Za-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}
