package com.example.lawyerfinderapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookAppointmentActivity extends AppCompatActivity {

    private ImageView lawyerImage;
    private TextView lawyerName, lawyerType;
    private Button bookButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        // Initialize UI Elements
        lawyerImage = findViewById(R.id.listImage);
        lawyerName = findViewById(R.id.textViewName);
        lawyerType = findViewById(R.id.textViewType);
        bookButton = findViewById(R.id.buttonBook);
        cancelButton = findViewById(R.id.buttonCancel);

        // Retrieve Data from Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("lawyer_name");
            String type = extras.getString("lawyer_type");
            int imageRes = extras.getInt("lawyer_image");

            lawyerName.setText(name);
            lawyerType.setText(type);
            lawyerImage.setImageResource(imageRes);
        }

        // Handle Book Button
        bookButton.setOnClickListener(v -> {
            // TODO: Implement booking logic
        });

        // Handle Cancel Button
        cancelButton.setOnClickListener(v -> finish());
    }
}
